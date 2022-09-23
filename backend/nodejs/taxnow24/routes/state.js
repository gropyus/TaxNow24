const express = require('express');
const router = express.Router();

const states = ['UT', 'NV', 'TX', 'AL'];
const taxes = {};

router.get('/', (_req, res) => {
  res.status(200).send(states);
});

router.post('/:state/tax', (req, res) => {
  const { state } = req.params;
  const tax = parseFloat(req.body);
  taxes[state] = tax;

  res.status(204).send('');
});

module.exports = router;
