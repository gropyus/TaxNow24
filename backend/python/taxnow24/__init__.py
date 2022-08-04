from flask import Flask


def create_app():
    # create and configure the app
    app = Flask(__name__)

    from . import state_controller
    app.register_blueprint(state_controller.bp)

    return app
