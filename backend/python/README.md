# TaxNow24 - Python

## Set up

```bash
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
```

## Running tests

```bash
python -m pytest
```

## Running the service

```bash
# start the server
FLASK_APP=taxnow24 flask run

# interact - get the list of supported states
curl 127.0.0.1:5000/states
# interact - define the tax amount per state
curl -X POST -H 'Content-Type: application/json' -d '0.08' 127.0.0.1:5000/states/UT/tax
```
