db.articulo.aggregate(
[
{$project:
 { denominacion: { $toUpper: "$denominacion" },
 importe: { $multiply: ["$pvp", "$uv" ] },
 stockactual: {$subtract: ["$stock", "$uv"] },
 areponer: {
 $cond: [{$lte: [{ $subtract: ["$stock", "$uv"]}, 0] },true,false]
 }
} }
] );