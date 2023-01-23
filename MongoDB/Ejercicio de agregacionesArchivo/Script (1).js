db.media.aggregate([{$match: {tipo:"CD"}},
                    {$project: {Artista: "$Artista",
                                TituloCanción: "$TituloCanción",
                                TituloCanciones: "$canciones.titulo"}
                    }])