db.media.aggregate([{$match : {tipo:"DVD"}},
                    {$group: {_id: "$estreno", contador: {$sum: 1}}
                    }])
