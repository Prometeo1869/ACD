db.articulo.aggregate( [ { $group: 
    { _id: "$categoria", 
        contador: { $sum: 1},
        sumaunidades: {$sum: "$uv"}, 
        totalimporte: { $sum: 
            { $multiply: [ "$pvp", "$uv"] 
} } } } ] );