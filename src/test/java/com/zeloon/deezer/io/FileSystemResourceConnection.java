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
package com.zeloon.deezer.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileSystemResourceConnection implements ResourceConnection {

    public String getData(String url) throws IOException {

        if (url.equals("http://api.deezer.com/album/302127")) {
            return readFileToString("albumService/exampleAlbum.json");
        } else if (url.equals("http://api.deezer.com/album/302127/fans")) {
            return readFileToString("albumService/exampleFans.json");
        } else if (url.equals("http://api.deezer.com/album/302127/comments")) {
            return readFileToString("albumService/exampleComments.json");
        } else if (url.equals("http://api.deezer.com/album/302127/tracks")) {
            return readFileToString("albumService/exampleTracks.json");
        } else if (url.equals("http://api.deezer.com/artist/27")) {
            return readFileToString("artistService/exampleArtist.json");
        } else if (url.equals("http://api.deezer.com/artist/27/top")) {
            return readFileToString("artistService/exampleTop.json");
        } else if (url.equals("http://api.deezer.com/artist/27/albums")) {
            return readFileToString("artistService/exampleAlbums.json");
        } else if (url.equals("http://api.deezer.com/artist/27/comments")) {
            return readFileToString("artistService/exampleComments.json");
        } else if (url.equals("http://api.deezer.com/artist/27/fans")) {
            return readFileToString("artistService/exampleFans.json");
        } else if (url.equals("http://api.deezer.com/artist/27/related")) {
            return readFileToString("artistService/exampleRelated.json");
        } else if (url.equals("http://api.deezer.com/artist/27/radio")) {
            return readFileToString("artistService/exampleRadio.json");
        } else if (url.equals("http://api.deezer.com/comment/2772704")) {
            return readFileToString("singleMethodService/exampleComment.json");
        } else if (url.equals("http://api.deezer.com/editorial")) {
            return readFileToString("singleMethodService/exampleEditorial.json");
        } else if (url.equals("http://api.deezer.com/genre")) {
            return readFileToString("singleMethodService/exampleGenre.json");
        } else if (url.equals("http://api.deezer.com/infos")) {
            return readFileToString("singleMethodService/exampleInfos.json");
        } else if (url.equals("http://api.deezer.com/track/3135556")) {
            return readFileToString("singleMethodService/exampleTrack.json");
        } else if (url.equals("http://api.deezer.com/playlist/4341978")) {
            return readFileToString("playlistService/examplePlaylist.json");
        } else if (url.equals("http://api.deezer.com/playlist/4341978/comments")) {
            return readFileToString("playlistService/exampleComments.json");
        } else if (url.equals("http://api.deezer.com/playlist/4341978/fans")) {
            return readFileToString("playlistService/exampleFans.json");
        } else if (url.equals("http://api.deezer.com/playlist/4341978/tracks")) {
            return readFileToString("playlistService/exampleTracks.json");
        } else if (url.equals("http://api.deezer.com/radio")) {
            return readFileToString("radioService/exampleRadio.json");
        } else if (url.equals("http://api.deezer.com/radio/genres")) {
            return readFileToString("radioService/exampleGenres.json");
        } else if (url.equals("http://api.deezer.com/radio/top")) {
            return readFileToString("radioService/exampleTop.json");
        } else if (url.startsWith("http://api.deezer.com/search?q")) {
            return readFileToString("searchService/exampleSearch.json");
        } else if (url.startsWith("http://api.deezer.com/search/album?q")) {
            return readFileToString("searchService/exampleSearchAlbum.json");
        } else if (url.startsWith("http://api.deezer.com/search/artist?q")) {
            return readFileToString("searchService/exampleSearchArtist.json");
        } else if (url.startsWith("http://api.deezer.com/search/autocomplete?q")) {
            return readFileToString("searchService/exampleSearchAutocomplete.json");
        } else if (url.startsWith("http://api.deezer.com/search/user?q")) {
            return readFileToString("searchService/exampleSearchUser.json");
        } else if (url.equals("http://api.deezer.com/user/2529")) {
            return readFileToString("userService/exampleUser.json");
        } else if (url.equals("http://api.deezer.com/user/2529/albums")) {
            return readFileToString("userService/exampleAlbums.json");
        } else if (url.equals("http://api.deezer.com/user/2529/artists")) {
            return readFileToString("userService/exampleArtists.json");
        } else if (url.equals("http://api.deezer.com/user/2/albums")) {
            return readFileToString("userService/exampleError.json");
        } else if (url.equals("http://api.deezer.com/user/2529/tracks")) {
            return readFileToString("userService/exampleTracks.json");
        } else if (url.equals("http://api.deezer.com/user/2529/followings")) {
            return readFileToString("userService/exampleFollowings.json");
        } else if (url.equals("http://api.deezer.com/user/2529/radios")) {
            return readFileToString("userService/exampleRadios.json");
        } else if (url.equals("http://api.deezer.com/user/2529/playlists")) {
            return readFileToString("userService/examplePlaylists.json");
        } else if (url.equals("http://api.deezer.com/user/2529/followers")) {
            return readFileToString("userService/exampleFollowers.json");
        } else if (url.equals("http://api.deezer.com/user/2529/charts")) {
            return readFileToString("userService/exampleCharts.json");
        } else {
            return "";
        }
    }

    private String readFileToString(final String fileName) throws IOException {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        return FileUtils.readFileToString(file);
    }

}
