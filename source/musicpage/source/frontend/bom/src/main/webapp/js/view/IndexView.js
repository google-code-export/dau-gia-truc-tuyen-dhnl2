/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
function IndexView() {
    this.updateView = function() {
        var listSongsPlaying = this.model.playingSongsList;
        var ulListSongsPlaying = $("#listSongsPlaying")[0];
        ulListSongsPlaying.innerHTML = "";
        for (var i = 0; i < listSongsPlaying.length; i++) {
            var stringLi = templateManager.t("templatePlayingSongsList");
            stringLi = stringLi.replace("#text1#", listSongsPlaying[i].title);
            var li = $(stringLi)[0];
            ulListSongsPlaying.appendChild(li);
            $(li.children[4]).removeClass("undisplayed");
            $(li.children[1]).removeClass("undisplayed");
            $(li.children[2]).removeClass("undisplayed");
            $(li.children[3]).removeClass("undisplayed");
        }
        $('#listSongsPlaying').jScrollPane();

        var ulListSongsResult = $("#listSongsResult")[0];
        ulListSongsResult.innerHTML = "";
        var songsResultList = this.model.songsResultList;
        for (var i = 0; i < songsResultList.length; i++) {
            var stringLi = templateManager.t("templateListSongOfCategories");
            stringLi = stringLi.replace("#title#", songsResultList[i].title);
            stringLi = stringLi.replace("#artist#", songsResultList[i].artist);
            stringLi = stringLi.replace("#listenCount#", songsResultList[i].listenCount);
            var li = $(stringLi)[0];
            ulListSongsResult.appendChild(li);
        }
        $('#listSongsResult').jScrollPane();

        var ulListCategories = $("#listCategories")[0];
        ulListCategories.innerHTML = "";
        var categories = this.model.categories;

        for (var i = 0; i < categories.length; i++) {
            var stringLi = templateManager.t("templateListCategoriesName");
            stringLi = stringLi.replace("#name#", categories[i].title);
            var li = $(stringLi)[0];
            ulListCategories.appendChild(li);
        }
    }
}
BaseView.inherits(IndexView);