const request = require('supertest');
const app = require('../app');

describe('State Suite', () => {
  it('should return states', (done) => {
    request(app)
      .get('/states')
      .expect('Content-Type', /json/)
      .expect(200, done);
  });

  it('should update UT state tax', (done) => {
    request(app)
      .post('/states/UT/tax')
      .send('0.08')
      .set('Content-Type', 'application/json')
      .expect(204, done);
  });
});
