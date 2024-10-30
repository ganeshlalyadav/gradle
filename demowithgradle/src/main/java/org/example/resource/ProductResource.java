package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Inject
    private ProductRepository repository;

    @POST
    public Response createProduct(Product product) {
        logger.trace("Entering createProduct method");
        logger.debug("Received product: {}", product);
        logger.info("Creating product");
        repository.create(product);
        logger.warn("Creation might affect stock levels");
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Long id) {
        logger.trace("Entering getProduct method with id: {}", id);
        logger.info("Fetching product with ID: {}", id);
        Product product = repository.find(id);
        if (product == null) {
            logger.error("Product with ID: {} not found", id);
        }
        return product;
    }

    @GET
    public List<Product> getAllProducts() {
        logger.trace("Entering getAllProducts method");
        List<Product> products = repository.findAll();
        logger.info("Fetched all products, count: {}", products.size());
        return products;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        logger.trace("Entering deleteProduct method with id: {}", id);
        logger.info("Deleting product with ID: {}", id);
        try {
            repository.delete(id);
            logger.warn("Product deletion cannot be undone for ID: {}", id);
        } catch (Exception e) {
            logger.error("Fatal error during deletion of product with ID: {}", id, e);
        }
        return Response.noContent().build();
    }
}
