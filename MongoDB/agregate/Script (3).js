db.articulo.aggregate( [{$group: {_id: null,
                                  maximo: {$max: "$pvp"}} }
]);