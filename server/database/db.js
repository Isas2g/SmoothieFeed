const { Sequelize } = require("sequelize");
const { __prod__ } = require("../config/constants");

const sequelize = new Sequelize({
  dialect: "postgres",
  host: process.env.DB_HOST,
  port: process.env.DB_PORT,
  username: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_DBNAME,
  logging: __prod__ ? console.log : null,
});

module.exports = sequelize;
