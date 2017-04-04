/*==============================================================================

name:       PjInternetRadio.java

purpose:    An Internet Radio using the PumaJ Framework.
            
history:    Sun Nov 27, 2011 08:46:23 (LBM) created.

notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.

                           COPYRIGHT 2011 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.

==============================================================================*/
                                       // package ----------------------------//
 
                                       // imports ----------------------------//
import com.apple.eawt.AppEvent;
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import com.pumaj.PjApplication;
import com.pumaj.PjUtils;
import javafx.scene.paint.Stop;
import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

// PjInternetRadio ====================//
public class PjInternetRadio extends PjApplication
{
    protected JTextField textField;
    protected Action enter;
                                       // class constants --------------------//
                                       // (none)                              //
                                       // package instance variables ---------//
                                       // (none)                              //
                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected GvIMediaPlayer mediaPlayer;  // media player                        //
                                       // private instance variables ---------//
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       PjInternetRadio - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of PjInternetRadio if successful.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public PjInternetRadio()
{
    textField = new JTextField("I am feeling...");

    //setLayout(null);


    getFrame().setExtendedState(getFrame().MAXIMIZED_BOTH);
    getFrame().setResizable(true);
    getFrame().setDefaultCloseOperation(getFrame().EXIT_ON_CLOSE);
    getFrame().setTitle("Etyphonic");

    textField.setLayout(null);
    add(textField);
    textField.setBounds(0, 0, 150, 20);

    setImage("images/menu1.jpg");
    com.pumaj.PjRectangle bar= new com.pumaj.PjRectangle();
    bar.setHeight(50);
    bar.setWidth(1400);
    bar.setImage("images/toolbar.jpg");
    add(bar);
    setVisible(true);




    enter = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String input = textField.getText().toLowerCase();
            GvIMediaPlayer player = getMediaPlayer();
            Double volume = getMediaPlayer().getAudioVolume();

            try
            {

                String[]        mediaPaths =
                        {
                                "http://absolut.hoerradar.de/absolutradio-mp3?sABC=565qq9qr%230%23055q2p032206p105s2p61980o6srp5or%23yvfgrayvir.z3h&amsparams=playerid:listenlive.m3u;skey:1448991198",//germany
                                "http://live.m2stream.fr/m2chillout-128.mp3",//chillstep?
                                "http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio1_mf_p",//unitedkingdom pop
                                "http://powerhitz.powerhitz.com:5040/;?.mp3",//newyork hiphop station
                                "http://64.40.111.77:8000/;?.mp3",//beatles rock, 60s, 70s
                                "http://relay.181.fm:8058/;?.mp3",//soul and jazz
                                "http://www.1.fm/station/Blues",//blues
                                "http://66.85.154.211:9035/;?.mp3",//metal
                                "http://wpsu-ice.streamguys1.com:80/wpsu1?.mp3",//classical
                                "http://uwstream1.somafm.com:80/;?.mp3",//ambient,
                                "http://helsinki.radiostreamlive.com/radiosantaclaus_mp3-high",//christmas #10
                                "http://8f14.vd.aclst.com/dl.php/d7cVLE4SaN0/Bryson+Tiller+-+Dont+%28Explicit+Version%29.mp3?video_id=d7cVLE4SaN0&t=ZDdjVkxFNFNhTjAtMTIwNDIxNTA2My0xNDQ5OTc1MzU5LTc1MDQ5Mw%3D%3D&exp=16-12-2015&s=4b3ad44c30898571cbbdd5be5bbc9602", //blake
                                "http://72.13.82.82:5100/;", //blues number
                                "http://99.198.112.60/;", //oldies, big band
                                "",//14
                                "",//15
                                "",//16
                                "",//17
                                "",//18
                                "",//19
                                "",//20
                                "",//21
                                "http://f717.vd.aclst.com/dl.php/qFbrRXdruv4/Travis+Scott+-+Sloppy+Toppy+ft.+Migos+%26amp%3B+Peewee+Longway.mp3?video_id=qFbrRXdruv4&t=cUZiclJYZHJ1djQtODU0MTU4MDU0LTE0NTAxMjE2NzMtMjM4Mjc2&exp=17-12-2015&s=daeaf9f968b31356ac749e92239460e1",//#22
                };

                //setting word categories
                //positive neutral—forest, earth
                String[] interested= {"interested", "concerned", "affected", "interested", "fascinated", "intrigued", "absorbed", "inquisitive", "nosy", "snoopy", "engrossed", "curious"};
                String[] positive= {"positive", "eager", "keen", "earnest", "intent", "anxious", "inspired", "determined", "excited", "enthusiastic", "bold", "brave", "daring", "challenged", "optimistic", "re-enforced", "confident", "hopeful"};
                String[] open= {"open", "understanding", "confident", "reliable", "easy", "amazed", "free", "sympathetic", "satisfied", "receptive", "accepting", "kind"};
                String[] alive= {"alive", "playful", "courageous", "energetic", "liberated", "optimistic", "provocative", "impulsive", "free", "frisky", "animated", "spirited", "thrilled", "wonderful", "crazy"};
                String[] good= {"good", "calm", "peaceful", "at ease", "comfortable", "pleased", "encouraged", "clever", "surprised", "content", "quiet", "certain", "relaxed", "serene", "free and easy", "bright", "blessed", "reassured"};

                //positive strong—mountains, water (fireplace background?)
                String[] happy= {"happy", "great", "joyous", "lucky", "fortunate", "delighted", "overjoyed", "gleeful", "thankful", "important", "festive", "ecstatic", "satisfied", "glad", "cheerful", "sunny", "merry", "elated", "jubilant"};
                String[] love= {"love", "loving", "considerate", "affectionate", "sensitive", "tender", "devoted", "attracted", "passionate", "admiration", "warm", "touched", "sympathy", "close", "loved", "comforted", "drawn toward", "horny"};
                String[] strong= {"strong", "impulsive", "free", "sure", "certain", "rebellious", "unique", "dynamic", "tenacious", "hardy", "secure"};

                //negative strong—volcano
                String[] angry= {"angry", "irritated", "mad", "enraged", "hostile", "insulting", "sore", "annoyed", "upset", "hateful", "unpleasant", "offensive", "bitter", "aggressive", "resentful", "inflamed", "provoked", "infuriated", "incensed", "cross", "worked up", "boiling", "fuming", "indignant", "fucked"};
                String[] depressed= {"depressed", "lousy", "disappointed", "discouraged", "ashamed", "powerless", "diminished", "guilty", "dissatisfied", "miserable", "detestable", "repugnant", "despicable", "disgusting", "abominable", "terrible", "in despair", "sulky", "bad", "a sense of loss"};
                String[] hurt= {"hurt", "crushed", "tormented", "deprived", "pained", "tortured", "dejected", "rejected", "injured", "offended", "afflicted", "aching", "victimized", "heartbroken", "agonized", "appalled", "humiliated", "wronged", "alienated"};

                //negative neutral—need to get a rain picture!
                String[] confused= {"confused", "upset", "doubtful", "uncertain", "indecisive", "perplexed", "embarrassed", "hesitant", "shy", "stupefied", "disillusioned", "unbelieving", "skeptical", "distrustful", "misgiving", "lost", "unsure", "uneasy", "pessimistic", "tense"};
                String[] helpless= {"helpless", "incapable", "alone", "paralyzed", "fatigued", "useless", "inferior", "vulnerable", "empty", "forced", "despair", "frustrated", "distressed", "woeful", "pathetic", "tragic", "in a stew", "dominated"};
                String[] indifferent= {"indifferent", "insensitive", "dull", "nonchalant", "neutral", "reserved", "weary", "bored", "preoccupied", "cold", "disinterested", "lifeless"};
                String[] afraid= {"afraid", "fearful", "terrified", "suspicious", "anxious", "alarmed", "panic", "nervous", "scared", "worried", "frightened", "timid", "shaky", "restless", "doubtful", "threatened", "cowardly", "quaking", "menaced", "wary"};
                String[] sad= {"tearful", "sorrowful", "pained", "grief", "anguish", "desolate", "desperate", "pessimistic", "unhappy", "lonely", "grieved", "mournful", "dismayed", "sad"};

                //keywords
                String[] play= {"play", "resume", "go"};
                String[] stop= {"pause", "stop"};
                String[] louder= {"louder", "+"};
                String[] quieter= {"softer", "quieter", "-"};

                //new words
                String[] extras= new String[100];

                int numberSearches= play.length + stop.length + louder.length + quieter.length +interested.length + positive.length + open.length + alive.length + good.length + happy.length + love.length + strong.length + angry.length + depressed.length + hurt.length + confused.length + helpless.length + indifferent.length + afraid.length + sad.length + play.length + stop.length + louder.length + quieter.length + extras.length;


                //checking which background and music to implement—also we need to find a way to do a smooth transition rather than a sudden replacement of the background with an image
                for (int i=0; i<numberSearches; i++)
                    //positive neutral
                    if (i<interested.length && interested[i].equals(input)) {
                        player.setURI(mediaPaths[3]);
                        setImage("images/menu3.jpg");
                        //setBackground(new Color (0, 191,255));
                    }
                    else if (i<positive.length && positive[i].equals(input)) {
                        player.setURI(mediaPaths[0]);
                        setImage("images/menu1.jpg");
                        //setBackground(new Color(34, 139, 34));
                    }
                    else if (i<open.length && open[i].equals(input)) {
                        player.setURI(mediaPaths[9]);
                        setImage("images/menu9.jpg");
                        //setBackground(new Color(218, 165, 32));
                    }
                    else if (i<alive.length && alive[i].equals(input)) {
                        player.setURI(mediaPaths[5]);
                        setImage("images/menu11.jpg");
                        //setBackground(new Color(0, 255, 255));
                    }
                    else if (i<good.length && good[i].equals(input)) {
                        player.setURI(mediaPaths[2]);
                        setImage("images/menu1.jpg");
                        //setBackground(new Color(34, 139, 34));
                    }
                    //positive strong
                    else if (i<happy.length && happy[i].equals(input)) {
                        player.setURI(mediaPaths[4]);
                        setImage("images/menu11.jpg");
                        //setBackground(new Color(0, 255, 255));
                    }
                    else if (i<love.length && love[i].equals(input)) {
                        player.setURI(mediaPaths[15]);
                        setImage("images/menu8.jpg");
                        //setBackground(new Color(220, 20, 60));
                    }
                    else if (i<strong.length && strong[i].equals(input)) {
                        player.setURI(mediaPaths[7]);
                        setImage("images/menu4.jpg");
                        //setBackground(new Color(119, 136, 153));
                    }
                    //negative strong
                    else if (i<angry.length && angry[i].equals(input)) {
                        player.setURI(mediaPaths[7]);
                        setImage("images/menu2.jpg");
                        //setBackground(new Color(0, 0, 0));
                    }
                    else if (i<depressed.length && depressed[i].equals(input)) {
                        player.setURI(mediaPaths[16]);
                        setImage("images/menu6.jpg");
                        //setBackground(new Color(105, 105, 105));
                    }
                    else if (i<hurt.length && hurt[i].equals(input)) {
                        player.setURI(mediaPaths[12]);
                        setImage("images/menu6.jpg");
                        //setBackground(new Color(138, 43, 226));
                    }
                    //negative neutral
                    else if (i<confused.length && confused[i].equals(input)) {
                        player.setURI(mediaPaths[17]);
                        setImage("images/menu7.jpg");
                        //setBackground(new Color(255, 255, 255));
                    }
                    else if (i<helpless.length && helpless[i].equals(input)) {
                        player.setURI(mediaPaths[17]);
                        setImage("images/menu10.jpg");
                        //setBackground(new Color(0, 0, 128));
                    }
                    else if (i<indifferent.length && indifferent[i].equals(input)) {
                        player.setURI(mediaPaths[16]);
                        setImage("images/menu5.jpg");
                        //setBackground(new Color(25, 25, 112));
                    }
                    else if (i<afraid.length && afraid[i].equals(input)) {
                        player.setURI(mediaPaths[18]);
                        setImage("images/menu7.jpg");
                        //setBackground(new Color(0, 0, 0));
                    }
                    else if (i<sad.length && sad[i].equals(input)) {
                        player.setURI(mediaPaths[18]);
                        setImage("images/menu6.jpg");
                        //setBackground(new Color(70, 130, 180));
                    }
                    //easter eggs
                    else if (i<1 && input.equals("jason")) {
                        player.setURI(mediaPaths[14]);
                    }
                    else if (i<1 && (input.contains("gang")||input.equals("turnup")||input.equals("hood")||input.equals("ball out")||input.equals("shwang")||input.equals("turn up")||input.equals("hype")||input.contains("af"))) {
                        player.setURI(mediaPaths[19]);
                    }
                    else if (i<1 && (input.contains("sensual")||input.contains("sex")))
                    {
                        player.setURI(mediaPaths[20]);
                    }
                    else if (i<1 && (input.equals("chase")))
                    {
                        player.setURI(mediaPaths[22]);
                    }
                    else if (i<1 && (input.contains("rain"))) {
                        player.setURI(mediaPaths[21]);
                        setImage("images/menu6.jpg");
                    }
                    else if (i<1 && input.equals("blake")) {
                        player.setURI(mediaPaths[11]);
                    }

                    //keywords
                    else if (i<quieter.length && quieter[i].equals(input))
                    {
                        if (volume > 0) {
                            getMediaPlayer().setAudioVolume(volume - 0.1);
                        }
                        else {
                            PjUtils.playNote();
                        }
                    } else if (i<louder.length && louder[i].equals(input))
                    {
                        if (volume<1) {
                            getMediaPlayer().setAudioVolume(volume + 0.1);
                        }
                        else {
                            PjUtils.playNote();
                        }
                    } else if (i < play.length && play[i].equals(input))
                    {
                        if (player.getPaused()) {
                            player.setPlaying(true);
                        }
                        else {
                            player.setURI(mediaPaths[(int)(Math.random()*21)]);
                        }
                    }
                    else if (i<stop.length && stop[i].equals(input))
                    {
                        player.setPaused(true);
                    }

            }
            catch(Exception E)
            {
                E.printStackTrace();
            }
        }
    };
    textField.addActionListener(enter);
}
/*------------------------------------------------------------------------------

@name       getMediaPlayer - get media player
                                                                              */
                                                                             /**
            Get media player instance.

@return     media player instance.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public GvIMediaPlayer getMediaPlayer()
{
   if (mediaPlayer == null)
   {
      mediaPlayer = new GvVLCMediaPlayer();
   }
   
   return(mediaPlayer);
}
/*------------------------------------------------------------------------------

@name       main - project main routine
                                                                              */
                                                                             /**
            Project main routine

@return     void.

@param      args  command line arguments

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public static void main(
   String   args[])
{
    new PjInternetRadio();
}
}//====================================// end PjInternetRadio ----------------//
