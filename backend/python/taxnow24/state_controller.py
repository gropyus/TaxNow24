import json

from flask import Blueprint, request

bp = Blueprint(name="states", import_name=__name__, url_prefix="/states")

states = ["UT", "NV", "TX", "AL"]
taxes = {}


@bp.route('', methods=['GET'])
def list_states():
    return json.dumps(states), 200, {'Content-Type': 'application/json'}


@bp.route("/<string:state>/tax", methods=['POST'])
def update_tax(state):
    tax = float(request.json)
    taxes[state] = tax
    return '', 204
