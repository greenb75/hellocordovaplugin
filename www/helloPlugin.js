/*global cordova, module*/

module.exports = {
    sayHello: function (name, successCallback, errorCallback) {
        var options = {};
        options.name = name;

        cordova.exec(successCallback, errorCallback, "HelloPlugin", "hello", [options]);
    },

    toastHello: function (message, duration, successCallback, errorCallback) {
        var options = {};
        options.message = message;
        options.duration = duration;

        cordova.exec(successCallback, errorCallback, "HelloPlugin", "toast", [options]);
    }
};
