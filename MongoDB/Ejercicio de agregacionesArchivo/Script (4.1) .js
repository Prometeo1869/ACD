db.media.aggregate([{$match : {tipo:"DVD"}}, 
                    {$group: {_id: "$Titulo", contador: {$sum: 1}}
                    }])
