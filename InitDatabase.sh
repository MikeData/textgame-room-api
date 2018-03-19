#!/usr/bin/env bash
mongo mongodb://localhost:27017/locations <<EOF
db.dropDatabase();

db.locations.insert({
      ",ocationName": "StartRoom",
      "locationDesc": " A small dingy room. The wet floor shallowly slopes to a " +
      "small grill in the center of the floor. Dim light comes from a single flickering bulb hanging from the ceiling " +
      "that fitfully illuminates a single heavy wooden door in the north wall." +
      "" +
      "The room smells of damp and neglect and something you can't place, something.....wrong.",
      "locationImage": ""
});

EOF
