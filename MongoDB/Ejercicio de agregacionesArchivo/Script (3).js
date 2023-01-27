db.media.aggregate({$match: {"Titulo":"Matrix"}}, 
                   {$project:{"_id":0, 
                              "Titulo":1,
                              "actores":1}}, 
                   {$unwind:"$actores"});
