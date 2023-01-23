db.trabajadores.aggregate( [{$match: {oficios: "Analista" } },
                            { $group: {_id: "analista",
                                       contador: {$sum: 1},
                                       media: {$avg: "$edad"} }
                            }
]);