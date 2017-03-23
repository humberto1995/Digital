package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {
	
	private ProdutoBO bo = new ProdutoBO();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO buscar(@PathParam("id") int codigo){
		ProdutoTO produto = bo.buscar(codigo);
		return produto;
	}
	
	//Listar...
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listar(){
		return bo.listar();
	}
	
	//Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo){
		//Cadastra no banco
		bo.cadastrar(produto);
		//Montar a URL para acessar o produto criado
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(produto.getCodigo()));
		//Retorna o status HTTP 201 com o link para o recurso criado
		return Response.created(url.build()).build();
	}
	
	//Atualizar
	
	//Remover
	
}



