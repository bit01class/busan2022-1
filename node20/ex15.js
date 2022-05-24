var url=require('url');
var myUrl='https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=java';
var myUrl=new url.URL(myUrl);
console.log(myUrl.origin);
console.log(myUrl.pathname);
// console.log(myUrl.searchParams);
console.log(myUrl.searchParams.keys());
for(var key of myUrl.searchParams.values())
    console.log(key);
    // console.log(key, myUrl.searchParams.get(key));