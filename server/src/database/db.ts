import "reflect-metadata";
import { __prod__ } from "../config/constants";
import { createConnection } from "typeorm";

// Connection to the database
const connect = async () => {
  return await createConnection({
    type: "postgres",
    host: process.env.DB_HOST,
    port: parseInt(process.env.DB_PORT!),
    username: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    name: process.env.DB_DBNAME,
    logging: __prod__,
    entities: [__dirname + "/entity/*.js"],
  });
};

export { connect };
