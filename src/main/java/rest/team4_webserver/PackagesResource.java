package rest.team4_webserver;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Package;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/package")
public class PackagesResource {
    public void PackageResource() {
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getpackages")
    public String getPackages() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createQuery("select p from Package p"); // could also use find() method
//        List<Package> list = query.getResultList();
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Package>>() {
//        }.getType(); // create TypeToken object, TypeToken needs a forced subclass (adding the curly braces), then calling an object from getType method

        return entityManager.toString(); // PLACEHOLDER, NEEDS TO BE FIXED
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getpackage/{pkgId}")
    public String getPackage(@PathParam("pkgId") int pkgId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Package pkg = entityManager.find(Package.class, pkgId);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Package>>() {
        }.getType();
        return gson.toJson(pkg, type);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("postpackage")
    public String postPackage(String jsonString) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Gson gson = new Gson();
        Package packageObject = gson.fromJson(jsonString, Package.class);
        entityManager.getTransaction().begin();
        Package mergedObject = entityManager.merge(packageObject);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "{'message': 'Package was updated'}";
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertpackage")
    public String putPackage(String jsonString) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Gson gson = new Gson();
        Package packageObject = gson.fromJson(jsonString, Package.class);
        entityManager.getTransaction().begin();
        entityManager.persist(packageObject);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "{'message': 'Package was inserted'}";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletepackage/{pkgId}")
    public String deletePackage(@PathParam("pkgId") int pkgId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Package pkg = entityManager.find(Package.class, pkgId);
        String message;
        if (pkg == null) {
            message = "{'message': 'Package not found'}";
        } else {
            entityManager.getTransaction().begin();
            entityManager.remove(pkg);
            entityManager.getTransaction().commit();
            message = "{'message': 'Package was deleted'}";
        }
        return message;
    }
}