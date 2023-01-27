db.media.mapReduce(function() {emit(this.Titulo, this.estreno);},
                   function(key, values) {return "{TotalPeliculas: " + Array.sum(values) + "}"},
                   {query: {tipo: "DVD"},
                   out: "TotalPeliculas"})
