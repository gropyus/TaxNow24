import pytest

from taxnow24 import create_app


@pytest.fixture
def client():
    app = create_app()

    with app.test_client() as client:
        yield client


def test_get_states(client):
    response = client.get('/states')
    assert 200 == response.status_code
    assert ["UT", "NV", "TX", "AL"] == response.json


def test_update_tax(client):
    response = client.post('/states/UT/tax', json=0.0685)
    assert 204 == response.status_code
