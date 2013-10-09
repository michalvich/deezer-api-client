/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zeloon.deezer.client;

import com.zeloon.deezer.domain.*;
import com.zeloon.deezer.domain.internal.*;
import com.zeloon.deezer.domain.internal.search.*;
import com.zeloon.deezer.io.ResourceConnection;
import com.zeloon.deezer.service.DeezerRestTemplate;

public class DeezerClient {

    public static final String PREFIX_ALBUM = "album";
    public static final String PREFIX_ARTIST = "artist";
    public static final String PREFIX_USER = "user";
    public static final String PREFIX_PLAYLIST = "playlist";

    private DeezerRestTemplate baseService;

    public DeezerClient(ResourceConnection resourceConnection) {
        baseService = new DeezerRestTemplate(resourceConnection);
    }

    public Album get(final AlbumId albumId) {
        return baseService.get(PREFIX_ALBUM, albumId.getId(), Album.class);
    }

    public Comments getComments(final AlbumId albumId) {
        return baseService.get(PREFIX_ALBUM, albumId.getId(), "comments", Comments.class);
    }

    public Fans getFans(final AlbumId albumId) {
        return baseService.get(PREFIX_ALBUM, albumId.getId(), "fans", Fans.class);
    }

    public Tracks getTracks(final AlbumId albumId) {
        return baseService.get(PREFIX_ALBUM, albumId.getId(), "tracks", Tracks.class);
    }

    public Artist get(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), Artist.class);
    }

    public Top getTop(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "top", Top.class);
    }

    public Albums getAlbums(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "albums", Albums.class);
    }

    public Comments getComments(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "comments", Comments.class);
    }

    public Fans getFans(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "fans", Fans.class);
    }

    public Related getRelated(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "related", Related.class);
    }

    public ArtistRadio getRadio(final ArtistId artistId) {
        return baseService.get(PREFIX_ARTIST, artistId.getId(), "radio", ArtistRadio.class);
    }

    public Editorial getEditorial() {
        return baseService.get("editorial", Editorial.class);
    }

    public Comment get(final CommentId commentId) {
        return baseService.get("comment", commentId.getId(), Comment.class);
    }

    public Genres getGenres() {
        return baseService.get("genre", Genres.class);
    }

    public Infos getInfos() {
        return baseService.get("infos", Infos.class);
    }

    public Track get(final TrackId trackId) {
        return baseService.get("track", trackId.getId(), Track.class);
    }

    public Playlist get(final PlaylistId playlistId) {
        return baseService.get(PREFIX_PLAYLIST, playlistId.getId(), Playlist.class);
    }

    public Comments getComments(final PlaylistId playlistId) {
        return baseService.get(PREFIX_PLAYLIST, playlistId.getId(), "comments", Comments.class);
    }

    public Fans getFans(final PlaylistId playlistId) {
        return baseService.get(PREFIX_PLAYLIST, playlistId.getId(), "fans", Fans.class);
    }

    public Tracks getTracks(final PlaylistId playlistId) {
        return baseService.get(PREFIX_PLAYLIST, playlistId.getId(), "tracks", Tracks.class);
    }

    public Radio getRadio() {
        return baseService.get("radio", Radio.class);
    }

    public RadioGenres getRadioGenres() {
        return baseService.get("radio/genres", RadioGenres.class);
    }

    public Radio getRadioTop() {
        return baseService.get("radio/top", Radio.class);
    }

    public Tracks search(final Search search) {
        return baseService.get("search?" + getSearchQuery(search), Tracks.class);
    }

    public Albums search(final SearchAlbum searchAlbum) {
        return baseService.get("search/album?" + getSearchQuery(searchAlbum), Albums.class);
    }

    public Artists search(final SearchArtist searchArtist) {
        return baseService.get("search/artist?" + getSearchQuery(searchArtist), Artists.class);
    }

    public Autocomplete search(final SearchAutocomplete searchAutocomplete) {
        return baseService.get("search/autocomplete?" + getSearchQuery(searchAutocomplete), Autocomplete.class);
    }

    public Users search(final SearchUser searchUser) {
        return baseService.get("search/user?q=" + searchUser.getText(), Users.class);
    }

    public User get(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), User.class);
    }

    public Albums getAlbums(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "albums", Albums.class);
    }

    public Artists getArtists(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "artists", Artists.class);
    }

    public Charts getCharts(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "charts", Charts.class);
    }

    public Followings getFollowings(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "followings", Followings.class);
    }

    public Followers getFollowers(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "followers", Followers.class);
    }

    public Playlists getPlaylists(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "playlists", Playlists.class);
    }

    public Radio getRadios(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "radios", Radio.class);
    }

    public Tracks getTracks(final UserId userId) {
        return baseService.get(PREFIX_USER, userId.getId(), "tracks", Tracks.class);
    }

    private String getSearchQuery(final Search search) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("q=");
        queryBuilder.append(search.getText());
        if (search.getSearchOrder() != null) {
            queryBuilder.append("&order=");
            queryBuilder.append(search.getSearchOrder());
        }
        return queryBuilder.toString();
    }

}
