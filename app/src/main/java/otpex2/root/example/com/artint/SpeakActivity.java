package otpex2.root.example.com.artint;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

import backCamera.BackCameraActivity;
import behind.BehindActivity;
import blueoff.BlueoffActivity;
import blueon.BlueonActivity;
import brightoff.BrightoffActivity;
import calculator.CalculatorActivity;
import camera.CameraActivity;
import chrome.ChromeActivity;
import clock.ClockActivity;
import contacts.ContactActivity;
import dataoff.DataoffActivity;
import dataon.DataonActivity;
import email.EmailActivity;
import facebook.Facebook;
import flightoff.FlightoffActivity;
import flighton.FlightonActivity;
import fullsensor.FullsensorActivity;
import fulluser.FulluserActivity;
import gallery.GalleryActivity;
import gmail.GmailActivity;
import google.Google;
import googledrive.GoogledriveActivity;
import googlemap.GooglemapActivity;
import gpsoff.GpsoffActivity;
import gpson.GpsonActivity;
import hardware.HardwareActivity;
import internet.InternetActitivity;
import land.Land;
import locked.LockedActivity;
import ludo.Ludo;
import memo.MemoActivity;
import messages.MessagesActivity;
import myfiles.MyfilesActivity;
import mygalaxy.MygalaxyActivity;
import myinfo.MyinfoActivity;
import nosensor.NosensorActivity;
import paytm.PaytmActivity;
import playstore.PlaystoreActivity;
import port.PortActivity;
import purpose.DorvisPurpose;
import radio.RadioActivity;
import recordstart.RecordstartActivity;
import revland.RevlandActivity;
import revport.RevportActivity;
import ringm.RingActivity;
import root.AdbActivity;
import screenshot.ScreenshotActivity;
import selfie.SelfieActivity;
import sensor.SensorActivity;
import sensorland.SensorlandActivaty;
import settings.SettingsActivity;
import silentm.SilentmActivity;
import sms.SmsActivity;
import systemoff.SystemoffActivity;
import systemrestart.SystemrestartActivity;
import train.TrainActivity;
import twitter.Twitter;
import userlandscape.UserlandscapeActivity;
import userportrait.Userportrait;
import vibratem.VibratemActivity;
import videos.VideosActivity;
import weather.Weather;
import welcome.Dorviswelcome;
import whatsapp.Whatsapp;
import wifioff.Wifioff;
import wifion.Wifion;
import youtube.YoutubeActivity;

public class SpeakActivity extends Activity  implements OnClickListener, TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    public ListView mList;
    public Button speakButton;
    private Intent callIntent;

    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak);
        mTTS = new TextToSpeech(this, this);
        speakButton = (Button) findViewById(R.id.btn_speak);
        speakButton.setOnClickListener(this);

        voiceinputbuttons();
    }

    public void voiceinputbuttons() {
        speakButton = (Button) findViewById(R.id.btn_speak);
        mList = (ListView) findViewById(R.id.list);
    }

    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    public void onClick(View v) {
        startVoiceRecognitionActivity();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {

            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));

            if (matches.contains("dervish ringing activate") || (matches.contains("Jarvis ringing mode activate")) || (matches.contains("ring mode")) || (matches.contains("ring")) || (matches.contains("ringing mode"))||(matches.contains("normal mode"))||(matches.contains("Normal Mode"))||(matches.contains("Normal mode"))||(matches.contains("normal Mode"))) {
                ringing();
            }
            else if (matches.contains("memo") || (matches.contains("Memo"))) {//Memo
                memo();
            }
            else if (matches.contains("YouTube") || (matches.contains("youtube")) || (matches.contains("Youtube")) || (matches.contains("YOUTUBE"))) {
                youtube();
            }
            else if (matches.contains("Paytm") || (matches.contains("paytm")) || (matches.contains("pay tm")) || (matches.contains("PAYTM"))) {
                paytm();
            }
            else if (matches.contains("chrome") || (matches.contains("Chrome")) || (matches.contains("google chrome")) || (matches.contains("CHROME")) || (matches.contains("GOOGLE CHROME"))) {//Google Chrome
                chorme();
            }
            else if (matches.contains("contacts") || (matches.contains("My Contacts")) || (matches.contains("my contacts")) || (matches.contains("My Contacts")) || (matches.contains("MY CONTACTS")) || (matches.contains("show my contacts")) || (matches.contains("SHOW MY CONTACTS"))) {
                contacts();
            }
            else if (matches.contains("camera") || (matches.contains("show camera")) || (matches.contains("take photo"))) {
                mycamera();
            }
            else if (matches.contains("wifi activate") || (matches.contains("WIFI ON")) || (matches.contains("Wifi On"))||(matches.contains("WI-FI on"))||(matches.contains("WiFi on"))||(matches.contains("Wi Fi on"))) {
                wifion();
            }
            else if (matches.contains("wifi off")||matches.contains("wifi deactivate")) {
                wifioff();
            }
            else if (matches.contains("adb") || (matches.contains("show root")) || (matches.contains("Show Root")) || (matches.contains("show Root")) || (matches.contains("Show root")) || (matches.contains("Root")) || (matches.contains("root"))) {
                adb();
            }
            else if (matches.contains("wheather") || (matches.contains("Wheather"))) {
                wheather();

            }
            else if (matches.contains("settings") || (matches.contains("Settings")) || (matches.contains("setting")) || (matches.contains("Setting")) || (matches.contains("show Settings")) || (matches.contains("Show Settings")) || (matches.contains("show Setting")) || (matches.contains("show setting")) || (matches.contains("Show Settings"))) {
                settings();

            }
            else if (matches.contains("Videos") || (matches.contains("my videos")) || (matches.contains("videos")) || (matches.contains("VIDEOS"))) {
                videos();

            }
            else if (matches.contains("radio") || (matches.contains("my fm")) || (matches.contains("my radio")) || (matches.contains("My Radio")) || (matches.contains("My radio")) || (matches.contains("my Radio"))) {
                radio();
            }
            else if (matches.contains("my Galaxy") || (matches.contains("my galaxy")) || (matches.contains("My Galaxy"))) {//my galaxy My Galaxy
                mygalaxy();
            }
            else if (matches.contains("MY FILES")||(matches.contains("files"))||(matches.contains("File"))||(matches.contains("file")) || (matches.contains("my Files")) || (matches.contains("My Files"))) {//my Files My Files MY FILES
                files();

            }
            else if (matches.contains("show map") || (matches.contains("Show Map")) || (matches.contains("show Map")) || (matches.contains("Show map"))||(matches.contains("map"))||(matches.contains("google map")) ||(matches.contains("Google Map"))||(matches.contains("Google map"))||(matches.contains("google map"))) {//Show Map, show Map Show map
                map();

            }
            else if (matches.contains("Gallery") || (matches.contains("gallery")) || (matches.contains("My Gallery")) || (matches.contains("my Gallery")) || (matches.contains("my gallery"))) {//gallery My Gallery my gallary
                gallery();

            }
            else if (matches.contains("clock") || (matches.contains("my clock")) || (matches.contains("Clock")) || (matches.contains("my Clock")) || (matches.contains("My Clock"))) {// my clock
                clock();

            }
            else if (matches.contains("Jarvis Chrome")||(matches.contains("Jarvis Chrome start"))||(matches.contains("Chrome"))||(matches.contains("chrome"))) {
                chrome();
            }
            else if (matches.contains("bluetooth on") || (matches.contains("Jarvis bluetooth activate")) || (matches.contains("blue tooth")) || (matches.contains("blue"))) {
                blueon();
            }

            else if (matches.contains("bluetooth off") || (matches.contains("bluetooth Off")) || (matches.contains("blue tooth off")) || (matches.contains("blue off"))) {

            }
            else if (matches.contains("Jarvis sms") || (matches.contains("Jarvis SMS")) || (matches.contains("show messages")) || (matches.contains("Show Messages")) || (matches.contains("show Messages")) || (matches.contains(""))) {//send SMS send messages send message
                sendsms();
            }
            else if (matches.contains("send email") || (matches.contains("Send Email")) || (matches.contains("send Email")) || (matches.contains("show Email")) || (matches.contains("Show Email")) || (matches.contains("show Emails")) || (matches.contains("Show Emails")) || (matches.contains("Emails")) || (matches.contains("email")) || (matches.contains("emails"))) {//Send Email send Email show Email Emails show Emails Show Emails
                sendemail();
            }
            else  if (matches.contains("recording start") || (matches.contains("Recording start")) || (matches.contains("Recording Start")) || (matches.contains("recording Start")) || (matches.contains("Recording start"))) { //recording start Recording Start recording Start Recording start
                recordingstart();
            }
            else if (matches.contains("back camera") || (matches.contains("camera")) || (matches.contains("Back Camera") || (matches.contains("Back camera")) || (matches.contains("back Camera")))) {
                backcamera();
            }
            else if (matches.contains("file manager") || (matches.contains("file Manager")) || (matches.contains("File Manager")) || (matches.contains("File manager"))) { //file Manager Manager File manager File Manager
                filemanager();
            }
            else if (matches.contains("behind sensor") || (matches.contains("Behind Sensor")) || (matches.contains("behind Sensor")) || (matches.contains("Behind sensor"))) {//
                behind();
            }
            else if (matches.contains("bluetooth off") || (matches.contains("Bluetooth off")) || (matches.contains("Bluetooth Off"))) {//Bluetooth off Bluetooth Off bluetooth Off
                blueoff();
            }
            else if (matches.contains("calculator") || (matches.contains("Calculator")) || (matches.contains("My Calculator")) || (matches.contains("my Calculator")) || (matches.contains("My calculator"))) { //Calculator My Calculator
                calculator();
            }
            else if (matches.contains("mobile data off") || (matches.contains("data off")) || (matches.contains("DATA OFF")) || (matches.contains("Data Off")) || (matches.contains("data Off"))) {//mobile data on Mobile Data On Data On data On Data on
                dataoff();
            }
            else if (matches.contains("data activate") || (matches.contains("mobile data activate")) || (matches.contains("Mobile Data On")) || (matches.contains("Data On")) || (matches.contains("Data on")) || (matches.contains("data On")||(matches.contains("data on")||(matches.contains("mobile data on"))||(matches.contains("data On"))))) {//mobile data on Mobile Data On Data On data On Data on
                dataon();
            }
            else if (matches.contains("flight mode deactivate") || (matches.contains("Jarvis flight mode deactivate")) || (matches.contains("Flight Mode Off")) || (matches.contains("Flight mode off")) || (matches.contains("Flight Mode off")) || (matches.contains("Flight Off")) || (matches.contains("flight Off"))) {
                flightoff();
            }
            else if (matches.contains("flight mode activate") || (matches.contains("Jarvis flight mode activate")) || (matches.contains("Flight Mode On")) || (matches.contains("Flight mode on")) || (matches.contains("Flight Mode on")) || (matches.contains("Flight On")) || (matches.contains("flight On"))) {
                flighton();
            }
            else if (matches.contains("full user") || (matches.contains("Full User")) || (matches.contains("Full user")) || (matches.contains("full User"))) {
                fulluser();
            }
            else if (matches.contains("full sensor") || (matches.contains("Full Sensor")) || (matches.contains("Full sensor")) || (matches.contains("full Sensor"))) {
                fullsensor();
            }
            else if (matches.contains("gmail") || (matches.contains("Gmail")) || (matches.contains("show gmail")) || (matches.contains("Show Gmail")) || (matches.contains("Show gmail")) || (matches.contains("show Gmail"))) {
                gmail();
            }
            else if (matches.contains("google drive") || (matches.contains("Google Drive")) || (matches.contains("Google drive")) || (matches.contains("google Drive")) || (matches.contains("My Drive")) || (matches.contains("my Drive")) || (matches.contains("My drive"))) {//Google Drive Google drive google Drive My Drive Drive drive my Drive
                googledrive();
            }
            else if (matches.contains("google map") || (matches.contains("show map")) || (matches.contains("Show Map")) || (matches.contains("Show map")) || (matches.contains("show Map"))) {
                gmap();
            }
            else if (matches.contains("gps off") ||(matches.contains("GPS of"))||(matches.contains("GPS Off"))||(matches.contains("GPS off")) ||(matches.contains("GPS of"))||(matches.contains("GPS Off")) || (matches.contains("Gps off")) || (matches.contains("GPS OFF"))) {
                gpsoff();
            }
            else if (matches.contains("gps on") || (matches.contains("GPS On")) || (matches.contains("GPS on")) || (matches.contains("GPS On")) || (matches.contains("GPS")) || (matches.contains("gps")||(matches.contains("gps activate"))||(matches.contains("GPS activate")))) {//GPS on GPS gps On
                gpson();
            }
            else if (matches.contains("hardware information") || (matches.contains("hardware")) || (matches.contains("Hardware")) || (matches.contains("Hardware information")) || (matches.contains("Hardware Information")) || (matches.contains("hardware Information"))) {//tell me about hardware hardware hardware input
                hardware();
            }
            else if (matches.contains("internet") || (matches.contains("Internet")) || (matches.contains("intranet")) || (matches.contains("inter net")) || (matches.contains("INTERNET"))) {//Internet inter net intranet enternet
                internet();
            }
            else if (matches.contains("landscape") || (matches.contains("Landscape")) || (matches.contains("my Landscape")) || (matches.contains("My landscape"))) {//Landscape my landscape
                land();
            }
            else if (matches.contains("locked sensor") || (matches.contains("Locked Sensor")) || (matches.contains("Locked sensor")) || (matches.contains("locked Sensor"))) {
                locked();
            }
            else if (matches.contains("show messages") || (matches.contains("Show Messages")) || (matches.contains("show Messages")) || (matches.contains("Show messages"))||(matches.contains("messages"))||(matches.contains("Messages"))||(matches.contains("message"))||(matches.contains("Message"))) {//Show messages Show Messages show Messages
                messages();
            }
            else if (matches.contains("my files") || (matches.contains("My files")) || (matches.contains("My Files")) || (matches.contains("Files"))) {//my Files My Files
                myfiles();
            }
            else if (matches.contains("my information") || (matches.contains("My information")) || (matches.contains("Myinfo"))) {//My Information my Information my info myinfo
                myinfo();
            }
            else if (matches.contains("no sensor") || (matches.contains("No Sensor")) || (matches.contains("no Sensor")) || (matches.contains("No sensor"))) {//No Sensor no Sensor No sensor
                nosensor();
            }
            // if(matches.contains("show pictures")||(matches.contains("Show Pictures"))|| (matches.contains("Show pictures"))||(matches.contains("show Pictures")) ||(matches.contains("show picture"))||(matches.contains("Show Picture"))){//Show Pictures Show picture show Picture
            //    pictures();
            //}
            else if (matches.contains("Play Store") || (matches.contains("playstore")) || (matches.contains("Play store")) || (matches.contains("play Store"))) { // play store Playstore playStore
                playstore();
            }
            else if (matches.contains("portrait") || (matches.contains("Portrait")) || (matches.contains("port"))) {//Portrait
                port();
            }
            else if (matches.contains("reverse land") || (matches.contains("Reverser Landscape")) || (matches.contains("reverser landscape")) || (matches.contains("Reverser landscape")) || (matches.contains("reverse Landscape")) || (matches.contains("rev land"))) {//Reverse Landscape reverser Land LandScape reverser Landscape
                revland();
            }
            else if (matches.contains("reverse port") || (matches.contains("Reverser Portrait")) || (matches.contains("reverser portrait")) || (matches.contains("Reverser portrait")) || (matches.contains("reverse Portrait")) || (matches.contains("rev port"))) {
                revport();
            }
            else if (matches.contains("show root")) {
                root();
            }
            else if (matches.contains("screenshots") || (matches.contains("Screenshots")) || (matches.contains("screenshot")) || (matches.contains("Screenshot")) || (matches.contains("screen shot")) || (matches.contains("Screen Shot")) || (matches.contains("Screen shot"))) {//Screen shots Screenshots Screen Shots
                screenshots();
            }
            else if (matches.contains("take selfie") || (matches.contains("Take Selfie")) || (matches.contains("Selfie")) || (matches.contains("selfie")) || (matches.contains("take my selfie")) || (matches.contains("TAKE MY SELFIE")) || (matches.contains("Take my selfie"))) {//Take selfie Take Selfie
                selfie();
            }
            else if (matches.contains("sensor") || (matches.contains("Sensor")) || (matches.contains("SENSOR"))) { //Sensor
                sensor();
            }
            else  if (matches.contains("sensor land") || (matches.contains("Sensor land")) || (matches.contains("Sensor Landscape")) || (matches.contains("sensor Landscape")) || (matches.contains("sensor landscape")) || (matches.contains("sensor Land"))) {//Sensor land Sensor Landscape sensor Land
                sensorland();
            }
            else if (matches.contains("silent mode") || (matches.contains("Silent Mode")) || (matches.contains("Silent mode")) || (matches.contains("silent")) || (matches.contains("Silent")) || (matches.contains("silence")) || (matches.contains("Silence")) || (matches.contains("I said silence")) || (matches.contains("i said silence"))) {//Silent Mode silentMode SilentMode silnt Mode
                silentmode();
            }
            else if (matches.contains("sms") || (matches.contains("SMS")) || (matches.contains("short message service")) || (matches.contains("Short Message Service"))) { //SMS
                sms();
            }
            else if (matches.contains("system shutdown") || (matches.contains("System Shutdown")) || (matches.contains("System shut down")) || (matches.contains("System Shut Down")) || (matches.contains("system shut down")) || (matches.contains("System off")) || (matches.contains("system Off")) || (matches.contains("system off")) || (matches.contains("shut down")) || (matches.contains("Shutdown")) || (matches.contains("shutdown")) || (matches.contains("Shut down")) || (matches.contains("shut Down")) || (matches.contains("Shut Down")) || (matches.contains("off"))) { //System off shutdown Shut Down Shutdown System Off system Off System off
                sysoff();
            }
            else if (matches.contains("system restart") || (matches.contains("System Restart")) || (matches.contains("System restart")) || (matches.contains("system restart")) || (matches.contains("restart")) || (matches.contains("Restart"))) {//System restart System Restart
                sysrestart();
            }
            else if (matches.contains("train") || (matches.contains("IRCTC")) || (matches.contains("show my trains")) || (matches.contains("I R C T C")) || (matches.contains("irctc")) || (matches.contains("Irctc")) || (matches.contains("Show my trains")) || (matches.contains("Train")) || (matches.contains("TRAIN")) || (matches.contains("show my trains")) || (matches.contains("Trains")) || (matches.contains("trains"))) {//Train
                train();
            }
            else if (matches.contains("user landscape") || (matches.contains("User Landscape")) || (matches.contains("User landscape")) || (matches.contains("user Landscape")) || (matches.contains("userlandscape") || (matches.contains("USERLANDSCAPE")))) {
                userland();
            }
            else if (matches.contains("user portrait")) {
                userport();
            }
            else if (matches.contains("vibrate mode") || (matches.contains("Vibrate Mode")) || (matches.contains("Vibrate mode")) || (matches.contains("vibrate")) || (matches.contains("Vibrate")) || (matches.contains("vibrats")) || (matches.contains("Vibrats")) || (matches.contains("I said vibrates")) || (matches.contains("i said vibrates")) || (matches.contains("I said vibrate")) || (matches.contains("I said Vibrates"))) {
                vibrate();
            }
            else if (matches.contains("whatsapp") || (matches.contains("Whats app")) || (matches.contains("what app")) || (matches.contains("whats up")) || (matches.contains("Whats up")) || (matches.contains("whatsup")) || (matches.contains("what"))) {
                whatsapp();
            }
            else if (matches.contains("bright off") || (matches.contains("Bright off")) || (matches.contains("Bright Off")) || (matches.contains("flash light off")) || (matches.contains("Flash Light off")) || (matches.contains("Brightness off")) || (matches.contains("brightness off")) || (matches.contains("Brightness Off")) || (matches.contains("brightness Off"))) {
                brightoff();
            }
            else if (matches.contains("bright on") || (matches.contains("Bright on")) || (matches.contains("Bright On")) || (matches.contains("flash light on")) || (matches.contains("Flash Light on")) || (matches.contains("Brightness on")) || (matches.contains("brightness on")) || (matches.contains("Brightness On")) || (matches.contains("brightness On"))||(matches.contains("Brighton"))) {
                brighon();
            }
            else if(matches.contains("who are you")||(matches.contains("kya ho tum"))||(matches.contains("Who Are you"))||(matches.contains("Who are you"))||(matches.contains("Who Are You"))){
                whoamI();
            }
            else if(matches.contains("uddesh kya hai")||(matches.contains("what is your primary target"))||(matches.contains("What is your purpose"))||(matches.contains("purpose"))||(matches.contains("Purpose"))||(matches.contains("par pose"))||(matches.contains("whats your purpose"))){
                purpose();
            }
            else if(matches.contains("google it")||(matches.contains("google"))||(matches.contains("Google it"))|| (matches.contains("Google"))||(matches.contains("open google"))||(matches.contains("Open Google"))||(matches.contains("open Google"))||(matches.contains("Open Google"))){
                google();
            }
            else if(matches.contains("ludo open")||(matches.contains("ludo"))||(matches.contains("ludo game"))||(matches.contains("Ludo"))||(matches.contains("Ludo Game"))||(matches.contains("ludo Game")) ||(matches.contains("ludo start"))||(matches.contains("Ludo Start"))||(matches.contains("Ludo start")) ||(matches.contains("Ludo start"))){
                ludo();
            }
            else if(matches.contains("twitter")||(matches.contains("Twitter"))||(matches.contains("twitter it"))||(matches.contains("Twitter it"))||(matches.contains("Twitter open"))||(matches.contains("twitter open"))||(matches.contains("open twitter"))||(matches.contains("Open twitter"))||(matches.contains("open Twitter"))||(matches.contains("twitter It"))||(matches.contains("Twitter It"))){
                twitter();
            }
            else if(matches.contains("facebook'")||(matches.contains("facebook"))||(matches.contains("facebook it"))||(matches.contains("Facebook it"))||(matches.contains("Facebook It"))||(matches.contains("open facebook"))||(matches.contains("Open facebook"))||(matches.contains("Open Facebook"))){
                facebook();
            }
            else  if(matches.contains("call dad")||(matches.contains("call to dad"))||(matches.contains("dad")))
            {
                dadcall();
            }
            else if (matches.contains("call irfan")||((matches.contains("call to irfan"))||(matches.contains("call to Irfan"))||(matches.contains("call irfan"))||(matches.contains("call Irfan"))))
            {
                irfancall();
            }
            else if(!matches.isEmpty()){
                voice();
            }
        }
    }

    private void irfancall() {
        callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:8149928949"));
        startActivity(callIntent);
        if (ActivityCompat.checkSelfPermission(SpeakActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    private void dadcall() {
        callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9175142266"));
        startActivity(callIntent);
        if (ActivityCompat.checkSelfPermission(SpeakActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    private void facebook() {
        Intent face = new Intent(SpeakActivity.this, Facebook.class);
        startActivity(face);
    }

    private void twitter() {
        Intent twit = new Intent(SpeakActivity.this, Twitter.class);
        startActivity(twit);
    }

    private void ludo() {
        Intent ludo = new Intent(SpeakActivity.this, Ludo.class);
        startActivity(ludo);
    }

    private void google() {
        Intent whopur = new Intent(SpeakActivity.this, Google.class);
        startActivity(whopur);
    }

    private void purpose() {
        Intent whopur = new Intent(SpeakActivity.this, DorvisPurpose.class);
        startActivity(whopur);
    }

    private void whoamI() {
        Intent who = new Intent(SpeakActivity.this, Dorviswelcome.class);
        startActivity(who);
    }

    private void brighon() {
        Intent brighton = new Intent(SpeakActivity.this, Whatsapp.class);
        startActivity(brighton);
    }

    private void whatsapp() {
        Intent what = new Intent(SpeakActivity.this, Whatsapp.class);
        startActivity(what);
    }

    private void vibrate() {
        Intent vib = new Intent(SpeakActivity.this, VibratemActivity.class);
        startActivity(vib);
    }

    private void userport() {
        Intent userport = new Intent(SpeakActivity.this, Userportrait.class);
        startActivity(userport);
    }

    private void userland() {
        Intent user = new Intent(SpeakActivity.this, UserlandscapeActivity.class);
        startActivity(user);
    }

    private void train() {
        Intent train = new Intent(SpeakActivity.this, TrainActivity.class);
        startActivity(train);
    }

    private void sysrestart() {
        Intent sysre = new Intent(SpeakActivity.this, SystemrestartActivity.class);
        startActivity(sysre);
    }

    private void sysoff() {
        Intent sysoff = new Intent(SpeakActivity.this, SystemoffActivity.class);
        startActivity(sysoff);
    }

    private void sms() {
        Intent sma = new Intent(SpeakActivity.this, SmsActivity.class);
        startActivity(sma);
    }

    private void silentmode() {
        Intent silentmode = new Intent(SpeakActivity.this, SilentmActivity.class);
        startActivity(silentmode);
    }

    private void sensorland() {
        Intent sensorland = new Intent(SpeakActivity.this, SensorlandActivaty.class);
        startActivity(sensorland);
    }

    private void sensor() {
        Intent sensor = new Intent(SpeakActivity.this, SensorActivity.class);
        startActivity(sensor);
    }

    private void selfie() {
        Intent sel = new Intent(SpeakActivity.this, SelfieActivity.class);
        startActivity(sel);
    }

    private void screenshots() {
        Intent sc = new Intent(SpeakActivity.this, ScreenshotActivity.class);
        startActivity(sc);
    }

    private void root() {
        Intent root = new Intent(SpeakActivity.this, AdbActivity.class);
        startActivity(root);
    }

    private void revport() {
        Intent revport = new Intent(SpeakActivity.this, RevportActivity.class);
        startActivity(revport);
    }

    private void revland() {
        Intent revland = new Intent(SpeakActivity.this, RevlandActivity.class);
        startActivity(revland);
    }

    private void port() {
        Intent port = new Intent(SpeakActivity.this, PortActivity.class);
        startActivity(port);
    }

    private void playstore() {
        Intent pl = new Intent(SpeakActivity.this, PlaystoreActivity.class);
        startActivity(pl);
    }

    private void nosensor() {
        Intent nosen = new Intent(SpeakActivity.this, NosensorActivity.class);
        startActivity(nosen);
    }

    private void myinfo() {
        Intent info = new Intent(SpeakActivity.this, MyinfoActivity.class);
        startActivity(info);
    }

    private void myfiles() {
        Intent files = new Intent(SpeakActivity.this, MyfilesActivity.class);
        startActivity(files);
    }

    private void messages() {
        Intent msg = new Intent(SpeakActivity.this, MessagesActivity.class);
        startActivity(msg);
    }

    private void locked() {
        Intent lock = new Intent(SpeakActivity.this, LockedActivity.class);
        startActivity(lock);
    }

    private void land() {
        Intent land = new Intent(SpeakActivity.this, Land.class);
        startActivity(land);
    }

    private void internet() {
        Intent in = new Intent(SpeakActivity.this, InternetActitivity.class);
        startActivity(in);
    }

    private void hardware() {
        Intent hd = new Intent(SpeakActivity.this, HardwareActivity.class);
        startActivity(hd);
    }

    private void gpson() {
        Intent gpson = new Intent(SpeakActivity.this, GpsonActivity.class);
        startActivity(gpson);
    }

    private void gpsoff() {
        Intent gpsoff = new Intent(SpeakActivity.this, GpsoffActivity.class);
        startActivity(gpsoff);
    }

    private void gmap() {
        Intent gmap = new Intent(SpeakActivity.this, GooglemapActivity.class);
        startActivity(gmap);
    }

    private void googledrive() {
        Intent gd = new Intent(SpeakActivity.this, GoogledriveActivity.class);
        startActivity(gd);
    }

    private void gmail() {
        Intent gmail = new Intent(SpeakActivity.this, GmailActivity.class);
        startActivity(gmail);
    }

    private void fullsensor() {
        Intent fullsensor = new Intent(SpeakActivity.this, FullsensorActivity.class);
        startActivity(fullsensor);
    }

    private void fulluser() {
        Intent fulluser = new Intent(SpeakActivity.this, FulluserActivity.class);
        startActivity(fulluser);
    }

    private void flighton() {
        Intent flighton = new Intent(SpeakActivity.this, FlightonActivity.class);
        startActivity(flighton);
    }

    private void flightoff() {
        Intent flightoff = new Intent(SpeakActivity.this, FlightoffActivity.class);
        startActivity(flightoff);
    }

    private void dataon() {
        Intent dataon = new Intent(SpeakActivity.this, DataonActivity.class);
        startActivity(dataon);
    }

    private void dataoff() {
        Intent dataoff = new Intent(SpeakActivity.this, DataoffActivity.class);
        startActivity(dataoff);
    }

    private void calculator() {
        Intent cal = new Intent(SpeakActivity.this, CalculatorActivity.class);
        startActivity(cal);
    }

    private void brightoff() {
        Intent brighoff = new Intent(SpeakActivity.this, BrightoffActivity.class);
        startActivity(brighoff);
    }

    private void blueoff() {
        Intent blueoff = new Intent(SpeakActivity.this, BlueoffActivity.class);
        startActivity(blueoff);
    }

    private void behind() {
        Intent behind = new Intent(SpeakActivity.this, BehindActivity.class);
        startActivity(behind);
    }

    private void filemanager() {
        Intent record = new Intent(SpeakActivity.this, RecordstartActivity.class);
        startActivity(record);
    }

    private void backcamera() {
        Intent bcamera = new Intent(SpeakActivity.this, BackCameraActivity.class);
        startActivity(bcamera);
    }

    private void recordingstart() {
        Intent record = new Intent(SpeakActivity.this, RecordstartActivity.class);
        startActivity(record);
    }

    private void sendemail() {
        Intent email = new Intent(SpeakActivity.this, EmailActivity.class);
        startActivity(email);
    }

    private void sendsms() {
        Intent sms = new Intent(SpeakActivity.this, SmsActivity.class);
        startActivity(sms);
    }

    private void blueon() {
        Intent blueon = new Intent(SpeakActivity.this, BlueonActivity.class);
        startActivity(blueon);
    }

    private void chrome() {
        Intent chrome = new Intent(SpeakActivity.this, ChromeActivity.class);
        startActivity(chrome);
    }

    private void clock() {
        Intent wifion = new Intent(SpeakActivity.this, ClockActivity.class);
        startActivity(wifion);
    }

    private void gallery() {
        Intent gallery = new Intent(SpeakActivity.this, GalleryActivity.class);
        startActivity(gallery);
    }

    private void map() {
        Intent wifion = new Intent(SpeakActivity.this, GooglemapActivity.class);
        startActivity(wifion);
    }

    private void files() {
        Intent myfiles = new Intent(SpeakActivity.this, MyfilesActivity.class);
        startActivity(myfiles);
    }

    private void mygalaxy() {
        Intent galaxy = new Intent(SpeakActivity.this, MygalaxyActivity.class);
        startActivity(galaxy);
    }

    private void radio() {
        Intent radio = new Intent(SpeakActivity.this, RadioActivity.class);
        startActivity(radio);
    }

    private void videos() {
        Intent videos = new Intent(SpeakActivity.this, VideosActivity.class);
        startActivity(videos);
    }

    private void settings() {
        Intent settings = new Intent(SpeakActivity.this, SettingsActivity.class);
        startActivity(settings);
    }

    private void wheather() {
        Intent weather = new Intent(SpeakActivity.this, Weather.class);
        startActivity(weather);
    }

    private void adb() {
        Intent adb = new Intent(SpeakActivity.this, AdbActivity.class);
        startActivity(adb);
    }

    private void wifioff() {
        Intent wifioff = new Intent(SpeakActivity.this, Wifioff.class);
        startActivity(wifioff);
    }

    private void wifion() {
        Intent wifion = new Intent(SpeakActivity.this, Wifion.class);
        startActivity(wifion);
    }

    private void mycamera() {
        Intent cameras = new Intent(SpeakActivity.this, CameraActivity.class);
        startActivity(cameras);
    }

    private void contacts() {
        Intent contacts = new Intent(SpeakActivity.this, ContactActivity.class);
        startActivity(contacts);
    }

    private void chorme() {
        Intent chrome = new Intent(SpeakActivity.this, ChromeActivity.class);
        startActivity(chrome);
    }

    private void paytm() {
        Intent mypay = new Intent(SpeakActivity.this, PaytmActivity.class);
        startActivity(mypay);
    }

    private void youtube() {
        Intent myyou = new Intent(SpeakActivity.this, YoutubeActivity.class);
        startActivity(myyou);
    }

    private void memo() {
        Intent mymemo = new Intent(SpeakActivity.this, MemoActivity.class);
        startActivity(mymemo);
    }

    private void ringing() {
        Intent ringintent = new Intent(SpeakActivity.this, RingActivity.class);
        startActivity(ringintent);
    }

    @Override
    public void onInit(int status) {
        voice();
    }

    private void voice()
    {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("command not found", TextToSpeech.QUEUE_ADD, null, null);
    }
}
