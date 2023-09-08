import {rest} from "msw";

export const handlers = [
    rest.post("http://localhost:8080/timeConversion/berlinTime/singleMinutesRow", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json([
            {
                "id": 1,
                "lighted": true,
                "yellow": true
            },
            {
                "id": 2,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 3,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 4,
                "lighted": false,
                "yellow": true
            }
        ])
    }),
    rest.post("http://localhost:8080/timeConversion/berlinTime/fiveMinutesRow", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json([
            {
                "id": 1,
                "lighted": true,
                "yellow": true
            },
            {
                "id": 2,
                "lighted": true,
                "yellow": true
            },
            {
                "id": 3,
                "lighted": false,
                "yellow": false
            },
            {
                "id": 4,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 5,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 6,
                "lighted": false,
                "yellow": false
            },
            {
                "id": 7,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 8,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 9,
                "lighted": false,
                "yellow": false
            },
            {
                "id": 10,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 11,
                "lighted": false,
                "yellow": true
            }
        ])
    }),
    rest.post("http://localhost:8080/timeConversion/berlinTime/singleHoursRow", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json([
            {
                "id": 1,
                "lighted": true,
                "yellow": true
            },
            {
                "id": 2,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 3,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 4,
                "lighted": false,
                "yellow": true
            }
        ])
    }),
    rest.post("http://localhost:8080/timeConversion/berlinTime/fiveHoursRow", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json([
            {
                "id": 1,
                "lighted": true,
                "yellow": true
            },
            {
                "id": 2,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 3,
                "lighted": false,
                "yellow": true
            },
            {
                "id": 4,
                "lighted": false,
                "yellow": true
            }
        ])
    }),
    rest.post("http://localhost:8080/timeConversion/berlinTime/secondsRow", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json([
            [{"id":1,"lighted":false,"yellow":true}]
        ])
    }),
    rest.post("http://localhost:8080/timeConversion/digitalTime", (req,res,ctx) =>{
        return res(ctx.status(200)),
        ctx.json(
            {"digitalTime":"00:00:00"}
        )
    }),
    
]