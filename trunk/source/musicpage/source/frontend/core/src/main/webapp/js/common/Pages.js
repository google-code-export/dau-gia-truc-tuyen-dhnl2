/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/6/13
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */

Pages = {}
Pages.index = [IndexController,TopAlbumController, IndexPlayerController,VolumeController];
Pages.index2 = {
    controllers:[TopAlbumController,IndexPlayerController, RecommendSongsController],
    ids:["indexPlayer","header","recommendSongs"],
	focus:[]//focus to embed view into it
};
