const express = require('express');
const createError = require('http-errors');
const logger = require('morgan');

const stateRouter = require('./routes/state');

const app = express();

app.use(logger('dev'));
app.use(express.json({ strict: false }));
app.use(express.urlencoded({ extended: false }));

app.use('/states', stateRouter);

app.use((_req, _res, next) => {
  next(createError(404));
});

app.use((err, req, res) => {
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  res.status(err.status || 500);
  res.send('error');
});

module.exports = app;
