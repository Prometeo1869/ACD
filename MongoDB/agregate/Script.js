db.articulo.aggregate([{$project:
     { denominacion: { $toUpper: "$denominacion" },
          importe: { $multiply: ["$pvp", "$uv" ] },
           stockactual: {$subtract: ["$stock", "$uv"] }
            }
             }
             ] )