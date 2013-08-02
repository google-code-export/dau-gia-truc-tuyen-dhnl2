package com.entertainment.musicpage.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entertainment.musicpage.dao.models.Album;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAOImpl;
import com.entertainment.musicpage.dto.ResponseRandListAlbum;

@Path("/data")
public class DataApi {

	@GET
	@Path("/randalbum")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseRandListAlbum printAccessToken() throws URISyntaxException {
		List<Album> l = new CustomAlbumDAOImpl().findRandNewsAlbum(0, 10);
		ResponseRandListAlbum res = new ResponseRandListAlbum(l);
		return res;
	}
}
