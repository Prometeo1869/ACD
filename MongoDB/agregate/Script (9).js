db.trabajadores.aggregate( [ { $project: {nombre: "$nombre.nom",
                                          numerooficios: {$size: { "$ifNull": ["$oficios", [] ] } },
                                          numeroprimas: { $size: { "$ifNull": ["$primas", [] ] } },
                                          oficiosconcatenados: {$concatArrays: [ "$oficios", "$primas" ] } 
                                          } } ] );
