db.articulo.aggregate( [ { $project: { primercarac: { $substr: ["$denominacion", 0, 1] }, 
                                       impor: {$multiply: ["$pvp", "$uv"] } } }, 
                         { $match: { "primercarac": {$in: ["m", "l"] } } }, 
                         { $group : { _id: 1, totalimporte: { $sum: "$impor" }
} } ] );