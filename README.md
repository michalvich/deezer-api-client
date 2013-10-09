deezer-api-client
=================

Java wrapper for deezer api - http://developers.deezer.com/api/

```java

// get Daft Punk
final DeezerClient deezerClient = new DeezerClient(new HttpResourceConnection());
final Artist artist = deezerClient.get(new ArtistId(27L));
System.out.println(artist.getName());

```

