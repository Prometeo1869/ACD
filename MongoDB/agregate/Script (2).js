db.articulo.aggregate ( [{$match: {categoria: "papelería"} },
                          {$group: {_id: "papeleria",
                                    contador: {$sum: 1},
                                    sumaunidades: {$sum: "$uv"},
                                    totalimporte: { $sum: 
                                                       { $multiply: ["$pvp", "$uv"] } }
                             } }
] );
