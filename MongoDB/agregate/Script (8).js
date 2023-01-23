db.trabajadores.aggregate( [{$sort: {"direccion.poblacion": 1} },
                            {$project: {población: "$direccion.población",
                                        nombre: "$nombre.nom",
                                        ape1: "$nombre.ape1",
                                        ape2: "$nombre.ape2",
                                        oficio1: {$arrayElemAt: ["$oficios", 0 ] },
                                        oficio2: {$arrayElemAt: ["$oficios", 1] },
                                        oficioultimo: {$arrayElemAt: ["$oficios", -1 ] } 
                                        } 
                            } ] );