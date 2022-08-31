var express = require("express");
const { request } = require("http");

var app = express();
var neo4j = require("neo4j-driver");
var driver = neo4j.driver(
  "bolt://localhost",
  neo4j.auth.basic("neo4j", "Anirudh@2001")
);

var session = driver.session();
app.set("view engine", "ejs");
app.get("/", (req, res) => {
  var str = req.query.preference;
  session
    .run(`MATCH(n:Teacher) MATCH (n:Teacher)-[r:${str}]-() RETURN n`)
    .then(function (result) {
      var out = [];
      result.records.forEach(function (record) {
        out.push({
          name: record._fields[0].properties.name,
          years_of_exp: record._fields[0].properties.years_of_exp,
          speciality: record._fields[0].properties.speciality,
          no_of_proj: record._fields[0].properties.no_of_proj,
        });
      });
      console.log(out);
      var o = [];
      for (var i = 0; i < out.length; i++) {
        if (i % 2 != 0) continue;
        o.push(out[i]);
      }
      function compare(a, b) {
        if (a.years_of_exp > b.years_of_exp) {
          return -1;
        }
        if (a.years_of_exp < b.years_of_exp) {
          return 1;
        }
        return 0;
      }
      o.sort(compare);
      res.render("home", { outp: o });
    })
    .catch();
});

var server = app.listen(4000, function () {
  console.log("listening to port 4000");
});
