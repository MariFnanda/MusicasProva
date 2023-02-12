# Tech4Music

Welcome to my code!


# In MongoDBCompass:

  - To create the database: 

use tech4music

  - To create the collection "musicas" + add songs: 

db.musicas.insertOne({"titulo": "Forever", "artista": "Kiss", "álbum": "Hot in the Shade", "genero": "Rock", "anoLancamento": 1989, "compositor": "Paul Stanley"})

  - To add more than one song at the same time:

db.musicas.insertMany([{"titulo": "Algo parecido", "artista": "Skank", "álbum": "Os três primeiros", "genero": "Pop", "anoLancamento": 2018, "compositor": "Samuel Rosa"}, {"titulo": "O que me importa", "artista": " Marisa Monte ", "álbum": "Memórias, crônicas e declarações de amor ", "genero": " MPB ", "anoLancamento": 2000, "compositor": "José de Ribamar Cury "}])


# In Postman:

To add new songs to the database: (POST) http://localhost:8080/api/musicas

To find a song by its ID: (GET) http://localhost:8080/api/musicas/ (the ID of the song)

To delete a song: (DELETE) http://localhost:8080/api/musicas/ (the ID of the song)

To change a song that already exists: (PUT) http://localhost:8080/api/musicas/ (the ID of the song)

To see how many songs exist in the database: (GET) http://localhost:8080/api/musicas/counting
