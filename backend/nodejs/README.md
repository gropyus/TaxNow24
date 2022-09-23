# TaxNow24 - Node.js

## Prerequisites

- Nodejs >= 16
- NPM

## Set up

```bash
npm i
```

## Local Development

```bash
npm run dev
```

## Running tests

```bash
npm run test
```

## Running the service

```bash
# start the server
npm start

# interact - get the list of supported states
curl 127.0.0.1:3000/states
# interact - define the tax amount per state
curl -X POST -H 'Content-Type: application/json' -d '0.08' 127.0.0.1:3000/states/UT/tax
```
