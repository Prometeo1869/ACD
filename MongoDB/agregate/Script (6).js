db.articulo.aggregate( [ {$sort: { categoria: -1,
                                    pvp: -1, denominacion: -1 }}, 
                          {$group: { _id: "$categoria", 
                                     mascaro: {$first: "$denominacion"}, 
                                               precio: { $first: "$pvp" } } } 
                        ] );