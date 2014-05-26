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
import com.zeloon.deezer.io.FileSystemResourceConnection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeezerClientTest {

    private DeezerClient deezerClient;

    private final UserId userId = new UserId(2529L);

    private final AlbumId albumId = new AlbumId(302127L);

    private final ArtistId artistId = new ArtistId(27L);

    private final PlaylistId playlistId = new PlaylistId(4341978L);

    @Before
    public void setUp() {
        deezerClient = new DeezerClient(new FileSystemResourceConnection());
    }

    @Test
    public void getAlbum() {
        final Album album = deezerClient.get(albumId);
        assertNotNull(album);
        assertEquals(albumId.getId(), album.getId());
        assertEquals("Discovery", album.getTitle());
        assertEquals("https://api.deezer.com/album/302127/tracks", album.getTracklist());
        assertEquals(1, album.getGenres().getData().size());
        final Genre firstGenre = album.getGenres().getData().get(0);
        assertEquals(Long.valueOf(113), firstGenre.getId());
        assertEquals("Taneční hudba", firstGenre.getName());
        assertEquals("genre", firstGenre.getType());
    }

    @Test
    public void getAlbumComments() {
        final Comments comments = deezerClient.getComments(albumId);
        assertNotNull(comments);
    }

    @Test
    public void getAlbumFans() {
        final Fans fans = deezerClient.getFans(albumId);
        assertNotNull(fans);
    }

    @Test
    public void getAlbumTracks() {
        final Tracks tracks = deezerClient.getTracks(albumId);
        assertNotNull(tracks);
        assertEquals(14, tracks.getTotal().intValue());
        Track track1 = tracks.getData().get(0);
        assertEquals(3135553, track1.getId().intValue());
        assertEquals(true, track1.getReadable());
        assertEquals("One More Time", track1.getTitle());
    }

    @Test
    public void testGetArtist() {
        final Artist artist = deezerClient.get(artistId);
        assertEquals(artistId.getId(), artist.getId());
        assertEquals("Daft Punk", artist.getName());
    }

    @Test
    public void testGetArtistTop() {
        final Top top = deezerClient.getTop(artistId);
        assertNotNull(top);
    }

    @Test
    public void testGetArtistAlbums() {
        Albums albums = deezerClient.getAlbums(artistId);
        assertNotNull(albums);
    }

    @Test
    public void testGetArtistComments() {
        Comments comments = deezerClient.getComments(artistId);
        assertNotNull(comments);
    }

    @Test
    public void testGetArtistFans() {
        Fans fans = deezerClient.getFans(artistId);
        assertNotNull(fans);
    }

    @Test
    public void testGetArtistRelated() {
        Related related = deezerClient.getRelated(artistId);
        assertNotNull(related);
    }

    @Test
    public void testGetArtistRadio() {
        ArtistRadio artistRadio = deezerClient.getRadio(artistId);
        assertNotNull(artistRadio);
    }

    @Test
    public void getEditorial() {
        assertNotNull(deezerClient.getEditorial());
    }

    @Test
    public void getComment() {
        assertNotNull(deezerClient.get(new CommentId(2772704L)));
    }

    @Test
    public void getGenres() {
        assertNotNull(deezerClient.getGenres());
    }

    @Test
    public void getInfos() {
        assertNotNull(deezerClient.getInfos());
    }

    @Test
    public void getTrack() {
        Track track = deezerClient.get(new TrackId(3135556L));
        assertEquals(3135556L, track.getId().longValue());
        assertEquals("Harder Better Faster Stronger", track.getTitle());
        assertNotNull(track.getAvailable_countries());
    }

    @Test
    public void getPlaylist() {
        Playlist playlist = deezerClient.get(playlistId);
        assertEquals(playlistId.getId(), playlist.getId());
    }

    @Test
    public void getPlaylistComments() {
        assertNotNull(deezerClient.getComments(playlistId));
    }

    @Test
    public void getPlaylistFans() {
        assertNotNull(deezerClient.getFans(playlistId));
    }

    @Test
    public void getPlaylistTracks() {
        assertNotNull(deezerClient.getTracks(playlistId));
    }

    @Test
    public void getRadio() {
        assertNotNull(deezerClient.getRadio());
    }

    @Test
    public void getRadioGenres() {
        assertNotNull(deezerClient.getRadioGenres());
    }

    @Test
    public void getRadioTop() {
        assertNotNull(deezerClient.getRadioTop());
    }

    @Test
    public void search() {
        deezerClient.search(new Search("test"));
    }

    @Test
    public void searchAlbum() {
        deezerClient.search(new SearchAlbum("test"));
    }

    @Test
    public void searchArtist() {
        deezerClient.search(new SearchArtist("test"));
    }

    @Test
    public void searchAutocomplete() {
        deezerClient.search(new SearchAutocomplete("test"));
    }

    @Test
    public void searchUser() {
        deezerClient.search(new SearchUser("test"));
    }

    @Test
    public void getUser() {
        assertNotNull(deezerClient.get(userId));
    }

    @Test
    public void getUserAlbums() {
        assertNotNull(deezerClient.getAlbums(userId));
    }

    @Test
    public void getUserArtists() {
        assertNotNull(deezerClient.getArtists(userId));
    }

    @Test
    public void getUserCharts() {
        assertNotNull(deezerClient.getCharts(userId));
    }

    @Test
    public void getUserFollowings() {
        assertNotNull(deezerClient.getFollowings(userId));
    }

    @Test
    public void getUserFollowers() {
        assertNotNull(deezerClient.getFollowers(userId));
    }

    @Test
    public void getUserPlaylists() {
        assertNotNull(deezerClient.getPlaylists(userId));
    }

    @Test
    public void getUserRadios() {
        assertNotNull(deezerClient.getRadios(userId));
    }

    @Test
    public void getTracks() {
        assertNotNull(deezerClient.getTracks(userId));
    }

}
