package io.helidon.examples.quickstart.mp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.concurrent.ConcurrentMap;

import static jakarta.ws.rs.core.Response.*;

@Path("/employees")
@RequestScoped
public class EmployeeResource {
    private final EmployeeRepository companies;
    @Context
    ResourceContext resourceContext;

    @Context
    UriInfo uriInfo;
    @Inject
    public EmployeeResource(EmployeeRepository companies) {
        this.companies = companies;
    }

    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getAll(){
        return ok(this.companies.all()).build();
    }

    @POST
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response savePost(@Valid Company movie) {
        Company saved = this.companies.save(Company.of(movie.getId(),movie.getTitle(),movie.getYear()));
        return created(
                uriInfo.getBaseUriBuilder()
                        .path("/employees/{id}")
                        .build(saved.getId())
        ).build();
    }


    @Path("{id}")
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("id") final int id) {
        Company company = this.companies.getById(id);
        if (company == null) {
            throw new EmployeeNotFoundException(id);
        }
        return ok(company).build();
    }

    @Path("{id}")
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response updateMovie(@PathParam("id") final int id, @Valid Company movie) {
        Company existed = this.companies.getById(id);
        existed.setTitle(movie.getTitle());
        existed.setYear(movie.getYear());

        Company saved = this.companies.save(existed);
        return noContent().build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteMovie(@PathParam("id") final int id) {
        this.companies.deleteById(id);
        return noContent().build();
    }
}




