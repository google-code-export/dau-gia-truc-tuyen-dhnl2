package com.entertainment.musicpage.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.entertainment.musicpage.dao.models.Song;
import com.entertainment.musicpage.daoimplement.CustomSongDAO;
import com.entertainment.musicpage.daoimplement.CustomSongDAOImpl;
import com.entertainment.musicpage.dto.Product;
import com.entertainment.musicpage.dto.ResponseShop;

@Path("/shop")
public class ShopApi {
	@GET
	@Path("/topdown")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseShop getTopDownProducts(@QueryParam("start")Integer start, @QueryParam("amount")Integer amount) {

		
		CustomSongDAO dao = new CustomSongDAOImpl();
		List<Song > lSongs = dao.findOrderById(start, amount);
		ArrayList<Product> lProducts = new ArrayList<Product>();
		Iterator<Song> it = lSongs.iterator();
		while(it.hasNext()){
			Song s = it.next();
			Product p = new Product(s.getTitle(), s.getCreatedTime().toString(), s.getDescription(), 99,"http://localhost:8081/shop/images/templatemo_image_04.jpg");
			lProducts.add(p);
		}
		
		ResponseShop resShop = new ResponseShop();
		resShop.setListProducts(lProducts);
		
		return resShop;
	}
}
