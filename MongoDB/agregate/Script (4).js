db.articulo.aggregate( [{$sort: {pvp: -1, 
                                 denominacion: -1 } },
                        {$group:{ _id:null,
                                  mascaro: {$first: "$denominacion"},
                                  precio: {$first: "$pvp"} }
                        } ] );