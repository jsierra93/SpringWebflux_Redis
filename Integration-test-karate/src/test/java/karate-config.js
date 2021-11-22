function init(){

config =  {
    host: 'http://127.0.0.1:8086',
    urlBase: '/v1/redis',
}

karate.configure('connectTimeout', 5000);
karate.configure('readTimeout', 5000);

return config;
}