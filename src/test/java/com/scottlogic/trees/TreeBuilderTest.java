package com.scottlogic.trees;

import com.scottlogic.collections.Tree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TreeBuilderTest {

    Map<String, TreeBuilder.Properties> createInput(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(TreeBuilder::parse)
                .collect(Collectors.toMap(
                        s -> s[0],
                        s -> new TreeBuilder.Properties(Integer.parseInt(s[1]), TreeBuilder.parseChildren(s[2]))));
    }

    @Test
    void apply() {

        Map<String, TreeBuilder.Properties> parsed = createInput(input);

        System.out.println(TreeBuilder.findRoot(parsed));
    }

    @Test
    void setSums() {
        Map<String, TreeBuilder.Properties> parsed = createInput(input);
        Tree<TreeBuilder.MyNode> tree = TreeBuilder.apply(parsed);
        TreeBuilder.setWeightSums(tree.root);

        TreeBuilder.MyNode node = TreeBuilder.findBadNode(tree.root);
        System.out.println("bad node " + node.name + " " + node.weightSum + " -- " + node.weight);

    }

    String test = "pbga (66)\n" +
            "xhth (57)\n" +
            "ebii (61)\n" +
            "havc (66)\n" +
            "ktlj (57)\n" +
            "fwft (72) -> ktlj, cntj, xhth\n" +
            "qoyq (66)\n" +
            "padx (45) -> pbga, havc, qoyq\n" +
            "tknk (41) -> ugml, padx, fwft\n" +
            "jptl (61)\n" +
            "ugml (68) -> gyxo, ebii, jptl\n" +
            "gyxo (61)\n" +
            "cntj (57)";

    String input = "jlbcwrl (93)\n" +
            "fzqsahw (256) -> lybovx, pdmhva\n" +
            "rxivjo (206) -> mewof, hrncqs, qgfstpq\n" +
            "jhldwxy (26)\n" +
            "bpzxjg (62)\n" +
            "lahain (70)\n" +
            "enbnfw (39)\n" +
            "uzsytm (45)\n" +
            "gmcsy (16)\n" +
            "rsqyvy (99)\n" +
            "lsbsfge (163) -> ldxgz, mksan\n" +
            "husmkc (29)\n" +
            "ootidjt (63)\n" +
            "pjhry (38)\n" +
            "kvlbq (22)\n" +
            "rdrad (6) -> gwyfm, fozyip, uotzz, fmkkz\n" +
            "oqbfkud (470) -> rnbqhk, mepez, mnksdxf, mjsck, bbfaxid, nglea\n" +
            "pgchejz (54) -> ifelr, rdkvtq\n" +
            "zzjyw (91)\n" +
            "yftjdo (12)\n" +
            "eqnvty (87)\n" +
            "adbolgz (38)\n" +
            "rcjqzp (65) -> mkyam, apdfe, avzljw, hxgidsw, fkgxak, wzsbsf, woczl\n" +
            "ksrsmjx (72)\n" +
            "wfdlusw (49)\n" +
            "rpoep (38)\n" +
            "jesiypo (78)\n" +
            "jjxvns (56)\n" +
            "syyfs (35)\n" +
            "otplae (91)\n" +
            "epsjj (17)\n" +
            "utgxfsh (959) -> mupbrv, borbd, jmieet\n" +
            "pxzdv (15)\n" +
            "ksybvgt (213)\n" +
            "tywzhc (243)\n" +
            "sbdja (16)\n" +
            "ctynr (63)\n" +
            "vwbjuvx (99)\n" +
            "aidknm (97)\n" +
            "qlgme (21) -> ehjnzn, cdbkci\n" +
            "zetvslt (99)\n" +
            "ferzy (65)\n" +
            "dssdiok (97)\n" +
            "gexdb (6)\n" +
            "bbzmsv (87)\n" +
            "mepez (126) -> uqvyau, witovp\n" +
            "pubtsp (70) -> jlvwibm, uvvdw, okmqiy\n" +
            "gjcxbx (44)\n" +
            "mogwb (84)\n" +
            "qwiekvk (65)\n" +
            "kwbovke (74)\n" +
            "offjbb (15) -> dvoja, jteju, wuybunc, qzpzi\n" +
            "cwdmlj (86)\n" +
            "ojpok (88)\n" +
            "lytcy (2662) -> bkmvwp, uyrwi\n" +
            "antcinm (178) -> dmthn, ycacj, wkhggv\n" +
            "kstvq (69)\n" +
            "ibysnvc (79)\n" +
            "xulwh (71)\n" +
            "zgqzrc (459) -> wlajxb, mfywm, jqmlxr\n" +
            "uyrwi (11)\n" +
            "qirjqsm (96)\n" +
            "fnoteku (2482) -> mbezs, kcuygjx, bymkeq, opsqjx\n" +
            "leeyi (88)\n" +
            "pcodkpi (95)\n" +
            "tetdx (224) -> nshbwn, rpoep, fbqpk\n" +
            "ajhctd (18)\n" +
            "yhzuh (72)\n" +
            "dmvjz (39)\n" +
            "zdgwmi (24)\n" +
            "vprkzya (37)\n" +
            "ipryqov (24)\n" +
            "pdxylvu (86) -> etscle, bqtawf\n" +
            "ehrqn (23) -> njabgq, fyzeso, jrgwnfh, fxasat\n" +
            "ekszr (148) -> gnmydtk, wchxl\n" +
            "izkaqg (26)\n" +
            "lovypfn (53)\n" +
            "sztqzfl (98)\n" +
            "ckwopo (43) -> yurfpj, bgrxlxe, tohrp\n" +
            "muksdck (48) -> gwtcgyo, tfpuqgs\n" +
            "tlfsn (21)\n" +
            "hrvztx (57)\n" +
            "psulm (1838) -> rhbouej, urhlfju, obfet\n" +
            "dbufjl (95) -> faihy, oyamw\n" +
            "ucfhxsv (65)\n" +
            "ietfhkq (31)\n" +
            "psvjtka (29)\n" +
            "wzxei (51)\n" +
            "swurfm (64)\n" +
            "oybwhs (18)\n" +
            "dmdiy (1601) -> lazjlns, ygvol, rljjjo, whnjtp, jilomb\n" +
            "jteju (54)\n" +
            "rdnpoms (177) -> eskdbe, fbhidp, xtkxwd\n" +
            "rdhwx (62)\n" +
            "hxgidsw (332) -> fukgfu, skkatyg\n" +
            "pcewixh (109) -> iekurr, xspxxb\n" +
            "gsiypfp (1146) -> bhwca, qhcolun\n" +
            "igpabio (53) -> mlqxueo, lhsncv\n" +
            "vdjmhb (39)\n" +
            "pwdpe (42) -> leeyi, rhlpt, dtexqt, skpcerk\n" +
            "ciejakr (43) -> hcqnhm, anmeg, melsryt\n" +
            "yehxck (2391) -> boygd, kayqqz, iajslqp\n" +
            "sofve (139)\n" +
            "asifeu (278) -> rtsajcq, dcouu\n" +
            "mgqfa (75) -> cipgxee, jscjw\n" +
            "kbppnh (99)\n" +
            "apwsmv (31)\n" +
            "dzjyzd (39)\n" +
            "uobgj (488) -> akidv, sofve, wblhx\n" +
            "qngfv (8)\n" +
            "kledju (95)\n" +
            "besihsl (86)\n" +
            "zqnmsyb (73)\n" +
            "csqfv (14)\n" +
            "ubgrma (1059) -> ymhxg, yvxuom, aeyykn\n" +
            "ufyqf (77)\n" +
            "llventw (308) -> lsbsfge, itxycu, nddymc\n" +
            "zfhwfsw (53)\n" +
            "kigdvl (31)\n" +
            "fiufzkb (1194) -> ysigfem, bchfd, hgsmlsi\n" +
            "vaubjz (233) -> erfnrn, gqzva, goxfpk\n" +
            "yhpiqn (99)\n" +
            "wzsbsf (222) -> mwztduj, hkpvwpa\n" +
            "mjaol (281) -> dnazkh, jkamtqv\n" +
            "mufnw (106) -> yxdld, obkhwze, nkssh\n" +
            "mhapqqy (16)\n" +
            "brztp (27)\n" +
            "ebmjz (68) -> xfydt, eqnvty\n" +
            "hkjwio (322) -> hdzxuz, zdgwmi, ipryqov\n" +
            "eszxg (18)\n" +
            "qwzac (908) -> uiioczf, qjdpk, ylpuaf\n" +
            "ndsub (75)\n" +
            "xcqwjrm (63)\n" +
            "glsrg (74) -> maiimn, ufyqf\n" +
            "mtcxdod (80)\n" +
            "ygmhxm (129) -> pljyyn, njdmj\n" +
            "ijcojo (1042) -> dxboqki, ikplh, pubtsp, omergh\n" +
            "urhlfju (249) -> csqfv, rnddnj\n" +
            "lgefkp (17)\n" +
            "bmmmp (90)\n" +
            "rjzrh (360) -> hbkujf, mzwbtsa, oywob, dmxhbe\n" +
            "khiom (117) -> hpaggeh, lqumiws\n" +
            "zlgpmfs (143) -> ilxfa, nhpcp\n" +
            "fozyip (293) -> kvlbq, pfqbht\n" +
            "ylpuaf (64) -> mdzkkjf, tfdbdq, kiauwpn\n" +
            "xekimqs (65)\n" +
            "bekxoxk (87)\n" +
            "zybeuh (197) -> wonxzkm, jzuvrtp\n" +
            "pudyrbw (76)\n" +
            "bcyarwn (65)\n" +
            "saowgr (367) -> gbnxgny, krmphks, yftjdo, zmpwz\n" +
            "tgmle (73) -> prcjhey, thzwwh, cxhipq, tgvpi\n" +
            "ezxsv (90) -> qzqyveb, dfmlo\n" +
            "rayez (17)\n" +
            "ujjpxe (56)\n" +
            "efsrz (93)\n" +
            "xaifomj (53)\n" +
            "ayury (23)\n" +
            "zavef (69)\n" +
            "qonfiro (190) -> cotvk, evqkdq\n" +
            "puurcu (1689) -> awagc, ajhctd\n" +
            "omergh (208)\n" +
            "padxpdx (192) -> psvjtka, husmkc\n" +
            "cxhipq (92)\n" +
            "jhgsgy (39)\n" +
            "leyiz (74) -> fvfek, njrfnvt\n" +
            "kdcvwyf (52)\n" +
            "zyympz (887) -> pxteg, amnoi, amzwex\n" +
            "jbbmcxg (34)\n" +
            "uvmqarq (751) -> muyodod, nclwgga, oeqvt\n" +
            "duepwu (683) -> hbueku, zbcra, yxtjx\n" +
            "aatagmv (44)\n" +
            "zsvuw (11)\n" +
            "fynniwm (35)\n" +
            "fjzpjk (88) -> uvsny, aatagmv\n" +
            "rulhhsl (90)\n" +
            "fcscdg (276) -> twvib, skjtvyz, oybwhs, rdmggka\n" +
            "vwotlbl (61)\n" +
            "ijyoy (24)\n" +
            "jpenh (186) -> kdcvwyf, rjxvbkb\n" +
            "qzpzi (54)\n" +
            "nshbwn (38)\n" +
            "foyfb (50)\n" +
            "kbyot (337) -> jhldwxy, izkaqg\n" +
            "bhxdhmr (65)\n" +
            "netsm (53)\n" +
            "tgffx (75) -> kstvq, cjmfqbo\n" +
            "msthql (7)\n" +
            "hgscccv (62)\n" +
            "dbnelj (212) -> jzcmf, sqiac, ijyoy, jjqguew\n" +
            "jxfqev (99)\n" +
            "elmog (32)\n" +
            "ygvol (202) -> mszzq, tzzdbi\n" +
            "gjrqs (159) -> iprkb, cgouh\n" +
            "rabxkov (84)\n" +
            "wenii (79) -> qsrpqe, zdhqhh, jpenh, hwrxn, vtvnn, mpgixa, fbjbwv\n" +
            "jkqvg (28)\n" +
            "kzdugfh (90)\n" +
            "mhkcp (17)\n" +
            "tfhdccw (93)\n" +
            "qzakfh (62)\n" +
            "hrncqs (12)\n" +
            "tzmndkd (221) -> lixsvp, ofyxhb\n" +
            "cjmfqbo (69)\n" +
            "ikplh (98) -> bqifoq, pjedtl\n" +
            "berje (87)\n" +
            "ikbqz (9)\n" +
            "avzljw (234) -> vdbihjp, zavef\n" +
            "ibiwh (26) -> ndsub, moihbcu\n" +
            "vdvadz (38)\n" +
            "yirnxk (158) -> lgefkp, rayez\n" +
            "vbnlfuo (169) -> pppxrv, rdhwx\n" +
            "lgxjr (238) -> mhkba, bsrkr\n" +
            "ynayo (71)\n" +
            "uvvdw (46)\n" +
            "udkyxw (48)\n" +
            "zotwsb (170) -> wlufwnr, frksv\n" +
            "tohdgsa (30)\n" +
            "bqtawf (45)\n" +
            "wrfxdc (25)\n" +
            "vjxmbzm (69)\n" +
            "opmmmd (32) -> pcodkpi, xhonf\n" +
            "hkpvwpa (75)\n" +
            "uflldd (39)\n" +
            "oelrlp (23)\n" +
            "lptkbzc (151) -> unvje, bzsiwp\n" +
            "ecdieu (23)\n" +
            "pxhwecw (57)\n" +
            "ryulu (61)\n" +
            "uplweb (127) -> bpzxjg, utivde\n" +
            "wblhx (97) -> xayglgm, pddllsa\n" +
            "grcox (91)\n" +
            "xergqq (99)\n" +
            "tgujvov (59) -> rhpco, ojpok, trbnpf\n" +
            "sdnkg (1381) -> gyutarg, gcwcs, mfjeyx\n" +
            "oydxsh (67)\n" +
            "pxihdrd (50)\n" +
            "cizehi (7)\n" +
            "zhopeqm (80)\n" +
            "frksv (89)\n" +
            "qvbfob (266) -> oejqkp, ocgkcxp\n" +
            "ldfsxw (17)\n" +
            "wltpv (260) -> nlndxah, etyyw\n" +
            "pddteg (52) -> lwwyx, mhnlgyl, mvfhc, dzggd, opqoq, mufrkl, inghbu\n" +
            "kybsigz (80)\n" +
            "hgsmlsi (31) -> bqqwmry, lqavsk\n" +
            "cbyvzkp (99)\n" +
            "tjpatnk (44)\n" +
            "srneoo (11) -> dhlrq, ivwcuc, laxoeu\n" +
            "piouhkc (95)\n" +
            "tgfgem (33)\n" +
            "egrfvic (49)\n" +
            "jmieet (137) -> ckwooig, stkodp\n" +
            "cldbz (15)\n" +
            "gylsj (52)\n" +
            "ecoqyk (35)\n" +
            "pnhibed (75) -> gmdsb, gijtd\n" +
            "fksxl (5)\n" +
            "rhpco (88)\n" +
            "eklahxm (51)\n" +
            "ftzht (8102) -> dmdiy, sfrbkzf, hlcnxe, zwsrt\n" +
            "cykvxs (84)\n" +
            "ccckie (201) -> tgkusb, alztgi\n" +
            "hbueku (10) -> ohcszyk, szutvca\n" +
            "cztikzk (174) -> wxdpcvv, lpbayb\n" +
            "lprmau (27) -> rqymw, dssdiok, dydwqz, eyale\n" +
            "zorvynv (176) -> mqybmn, jaxidl\n" +
            "laxoeu (88)\n" +
            "nvvxl (93)\n" +
            "duophdw (72)\n" +
            "qjwfsfk (11)\n" +
            "tzzdbi (8)\n" +
            "kwmam (184) -> wdybaj, cyielpd, hhifd, gexdb\n" +
            "ujktzrv (71)\n" +
            "dvoja (54)\n" +
            "opsqjx (71)\n" +
            "hlrjgro (63)\n" +
            "oqjkafl (32) -> iwyjkz, auneqme, awccm\n" +
            "vuyeiv (65)\n" +
            "qhmyi (130) -> dvfuz, scruak\n" +
            "tnayomw (62)\n" +
            "ezdhr (179)\n" +
            "ypfsjd (60) -> rdmrzdv, yhpiqn, cbyvzkp\n" +
            "auneqme (86)\n" +
            "kabixkr (73)\n" +
            "jntohm (41)\n" +
            "oyamw (65)\n" +
            "utivde (62)\n" +
            "qhcolun (76)\n" +
            "qjcbye (535) -> fetkt, pcewixh, vaubjz, ojhlp, mnvgaqh, rcjiwg\n" +
            "rfdpm (80) -> wcevmtt, tlayc\n" +
            "ovvrx (84)\n" +
            "zdhqhh (200) -> ylyef, onogiv, tohdgsa\n" +
            "ofidu (349) -> pjxqt, cytlm\n" +
            "zqmlv (59)\n" +
            "uzuawb (47)\n" +
            "unvje (71)\n" +
            "osbbt (1214) -> gqmscj, vyriv, bkkop\n" +
            "tmyhhql (51)\n" +
            "zxson (61)\n" +
            "rhlllw (11)\n" +
            "xtkxwd (17)\n" +
            "lijeejc (57) -> mgkkyx, thzyz\n" +
            "crhho (1255) -> rfcfgg, chnfm, tuekps\n" +
            "jqkaucw (53)\n" +
            "rerckg (63)\n" +
            "kgevjdx (84)\n" +
            "muyodod (19) -> wolet, zzjyw\n" +
            "zjzoo (65)\n" +
            "evqkdq (91)\n" +
            "mecyei (75)\n" +
            "bvfcsls (227) -> knpwsi, ypfsjd, eilzvpr\n" +
            "ntabiof (365) -> rfohgya, yoqbgjb\n" +
            "gqmscj (155) -> kjlmdi, scaec\n" +
            "bkmvwp (11)\n" +
            "tuekps (169)\n" +
            "mksan (18)\n" +
            "apmdcz (16)\n" +
            "plumb (89)\n" +
            "gcmio (126) -> ujjpxe, jjxvns\n" +
            "uqvyau (6)\n" +
            "bdkoa (125) -> ctynr, tvnco\n" +
            "xseshzl (76)\n" +
            "mnpvutr (39)\n" +
            "lghzki (27)\n" +
            "citugfl (14)\n" +
            "vxgwku (16)\n" +
            "jwaskb (251)\n" +
            "olkopyn (66) -> qjcbye, cstgeia, uojcup, ycctk, dkhuccj\n" +
            "jscjw (72)\n" +
            "xatyg (71)\n" +
            "xpfxwd (8)\n" +
            "jjjks (7331) -> qpefm, dlhiqh, gtervu, pcnroj, jijwa, bgbnlki\n" +
            "ewvvi (53)\n" +
            "ycbgx (1531) -> tzmndkd, fpynzz, tywzhc\n" +
            "cstgeia (613) -> ckwopo, sjiel, akwfu, ehvqyl, wtyfb, gcmio\n" +
            "ursjc (45)\n" +
            "mabkbom (57)\n" +
            "lafoho (250)\n" +
            "xmvbzka (49)\n" +
            "oasspz (67)\n" +
            "epumc (86) -> pcdjo, rerckg, dwknfpc\n" +
            "cyielpd (6)\n" +
            "lmqaxz (146) -> ghobhlm, qvvcx\n" +
            "ydqjoa (84)\n" +
            "zfkfhfn (33) -> txapm, pygfz, ekszr, nbivp, wltpv, jsjaxjk\n" +
            "sslltlv (45)\n" +
            "tifqyde (2264) -> koxiwk, psulm, rcjqzp\n" +
            "vonzkut (76) -> bdafpm, nvlxqp, gxsbt\n" +
            "blagy (338)\n" +
            "cluxnul (15)\n" +
            "kdevmnr (77)\n" +
            "cmxulaj (44) -> mnkqevh, mkbgt, nrcbc\n" +
            "tygwtg (25)\n" +
            "wpnqifq (11)\n" +
            "jilomb (68) -> uduan, mecyei\n" +
            "kytnz (52)\n" +
            "gynfwly (66) -> lynvd, dxhcxko, xaatl, leulsg, zworz, fkbrmim, jjjks\n" +
            "msfxkn (130) -> ietfhkq, kigdvl\n" +
            "wewzb (164) -> yzptgez, ctytfj\n" +
            "hdzxuz (24)\n" +
            "ghbfyqe (5)\n" +
            "hbkujf (133) -> ukghke, aplbnbx\n" +
            "iwsjla (38)\n" +
            "dnalt (35)\n" +
            "gmdsb (75)\n" +
            "pcnroj (2553) -> oljci, losdis, sdnkg, zchulv, crhho\n" +
            "dzrkq (94)\n" +
            "cjcapa (292)\n" +
            "dzohgiq (43)\n" +
            "rhlpt (88)\n" +
            "dkvzre (99) -> mieecfc, nvdouwn, dbnelj, onlwq, ayaouxu, xrhsy, bvrlaep\n" +
            "zpntow (72)\n" +
            "vohta (58)\n" +
            "jqmlxr (173) -> eiyxf, fydjnl\n" +
            "lxhkgs (85)\n" +
            "qoiuwmf (1008) -> vbnlfuo, wjyreb, sdbksb, lptkbzc, wopfs, khiom\n" +
            "btgrhku (24)\n" +
            "nnhsuja (16)\n" +
            "jgwvp (84)\n" +
            "vdpmvm (28)\n" +
            "iimfrx (59)\n" +
            "oyfma (21)\n" +
            "sqypc (7)\n" +
            "txapm (272) -> isggu, yookz\n" +
            "zhbiaq (45) -> rqzfef, kplegas, ayejq, xevhcxq\n" +
            "bkcghv (35)\n" +
            "yjakrqa (70)\n" +
            "lmwrf (51)\n" +
            "uwhjd (94)\n" +
            "bpphw (49)\n" +
            "vtvnn (114) -> uadnb, huunb\n" +
            "blmfs (52)\n" +
            "rtsajcq (6)\n" +
            "lazjlns (190) -> xbyjur, edjwkkk\n" +
            "rnddnj (14)\n" +
            "vobeup (41)\n" +
            "kifer (53)\n" +
            "jdzbqlz (15)\n" +
            "wlufwnr (89)\n" +
            "bqznix (75) -> stiln, duophdw, yhzuh\n" +
            "aovlz (45)\n" +
            "dyrvvfn (340) -> prxseo, vxgwku\n" +
            "ukghke (28)\n" +
            "lnczb (69) -> tzntd, cfnce\n" +
            "qllluo (57)\n" +
            "asbzj (89) -> yjxyb, hsifo, fhasacf, vwojb, gcbcyn\n" +
            "sruyra (47)\n" +
            "ohplzu (58)\n" +
            "fmkkz (319) -> owigu, ikbqz\n" +
            "zimrsr (223) -> dxympe, fhpaqmd, ayury\n" +
            "cdbkci (79)\n" +
            "tchbf (93)\n" +
            "wdybaj (6)\n" +
            "bexvn (39)\n" +
            "rcsfkrb (11)\n" +
            "bgbnlki (2277) -> oqbfkud, qsqis, xhyqtqz, qorkez, qwzac, oewlch, gsiypfp\n" +
            "zworz (41633) -> ootkqm, wfovakv, inldh\n" +
            "dwknfpc (63)\n" +
            "xjcprt (87)\n" +
            "ghobhlm (41)\n" +
            "erfndpf (89) -> kwbovke, adxhax, cipwzoy\n" +
            "setrric (31)\n" +
            "erggh (197) -> fksxl, ghbfyqe\n" +
            "pzksun (873) -> vyozfv, jxfqev, kbppnh\n" +
            "pddllsa (21)\n" +
            "xeomb (44) -> vuyeiv, bwrpskq, qwiekvk, gxzkde\n" +
            "dfmlo (80)\n" +
            "guvuihw (39)\n" +
            "khqhd (42)\n" +
            "fphgbca (59)\n" +
            "fhasacf (269) -> fovilf, rjnzany\n" +
            "oyamsv (38)\n" +
            "kjjyu (65)\n" +
            "pfqbht (22)\n" +
            "amzwex (218) -> vprkzya, wxixtqj, oktfn\n" +
            "lwljcg (85)\n" +
            "hpeaki (35)\n" +
            "rcjiwg (35) -> odckjtb, jlfgvr, tdbne\n" +
            "ktazkb (57)\n" +
            "tgvpi (92)\n" +
            "sdhqlxw (1239) -> eklahxm, ejzeqxz, kabcmf\n" +
            "aonfaf (52)\n" +
            "mlqxueo (67)\n" +
            "akidv (21) -> cnvyxm, fphgbca\n" +
            "bozlg (67)\n" +
            "ewpbnsk (64)\n" +
            "thzwwh (92)\n" +
            "tuieolg (7624) -> ldnrw, cfuqhip, rjzrh\n" +
            "tzrppo (51) -> tfhdccw, kbses, jlbcwrl, efsrz\n" +
            "fbjbwv (290)\n" +
            "dmthn (25)\n" +
            "witovp (6)\n" +
            "ugjzag (24)\n" +
            "agliie (844) -> qjaywg, rridl, myaiu, antcinm, izhdt\n" +
            "ebgdslc (31)\n" +
            "abmqz (31)\n" +
            "hsfjd (21)\n" +
            "ootkqm (9535) -> uplweb, bdkoa, ehrqn, fpqudx, assuj, rjguqr, jwaskb\n" +
            "ldxgz (18)\n" +
            "atfhgyu (57)\n" +
            "hbzju (71)\n" +
            "rrywqx (69)\n" +
            "dxqqhhd (188) -> pzewv, oelrlp\n" +
            "ixtrjm (92)\n" +
            "njeff (28)\n" +
            "dxboqki (78) -> nstdz, ferzy\n" +
            "mnwefbn (65)\n" +
            "bugfhhx (357) -> abbnh, intfltq\n" +
            "qorkez (1280) -> euqiok, ibvaekj\n" +
            "anbcmt (17)\n" +
            "iprkb (26)\n" +
            "vflyupn (34)\n" +
            "ruwzkz (362)\n" +
            "xrxseqy (94)\n" +
            "mszzq (8)\n" +
            "thzyz (77)\n" +
            "xyxtm (92)\n" +
            "qeubhb (65)\n" +
            "fmtyy (35)\n" +
            "hpowmso (1854) -> jhysc, xeomb, nzwxd\n" +
            "ywvmghy (63)\n" +
            "rridl (131) -> nqvflzq, vwotlbl\n" +
            "dydwqz (97)\n" +
            "mhnlgyl (1185) -> qntstgd, qzpgle, aozygag\n" +
            "uycjl (292) -> xcqvne, ruxnrix\n" +
            "ohcszyk (32)\n" +
            "gtervu (88) -> dkvzre, awufxne, osbbt, ycbgx, wdjzjlk\n" +
            "xcqvne (35)\n" +
            "moihbcu (75)\n" +
            "wpoga (57)\n" +
            "rjxvbkb (52)\n" +
            "bihsr (21) -> kyjkjy, hgscccv, yonjpz\n" +
            "vmmjgy (742) -> vdkxk, yhyxv, cpfbmv\n" +
            "gwnipjd (24)\n" +
            "brcpgz (57)\n" +
            "dczcz (1862) -> wszghwt, navhthp, lsfggz\n" +
            "wmaywuo (87)\n" +
            "vrfkofp (49)\n" +
            "nrcbij (64) -> pudyrbw, ghdime, xseshzl\n" +
            "yxtjx (74)\n" +
            "dnzdqz (179)\n" +
            "gxsbt (58)\n" +
            "oqrmida (222) -> lixqwd, dnalt\n" +
            "nddymc (93) -> ewvvi, netsm\n" +
            "iekurr (71)\n" +
            "tcghqr (43) -> mnhojtk, ruwzkz, veksns, wrochvi, uycjl, umtfn, qgvsuqv\n" +
            "ikfihh (140) -> tygwtg, vlmhyer\n" +
            "ziypsz (84)\n" +
            "ehjnzn (79)\n" +
            "exwxepj (175) -> jszpe, guvuihw, ykruy\n" +
            "capxp (68)\n" +
            "nhpcp (34)\n" +
            "qzpgle (77) -> gwnipjd, mrcoxnt\n" +
            "edjwkkk (14)\n" +
            "uteosk (65)\n" +
            "ofyxhb (11)\n" +
            "tulxgem (213) -> mabkbom, btcjg, ktazkb, evcdf\n" +
            "dkttrfw (219) -> ahqfoz, kytnz\n" +
            "mttvnpg (9)\n" +
            "tzntd (59)\n" +
            "euqiok (9)\n" +
            "wgypwo (290) -> btgrhku, aqkdlo\n" +
            "chnfm (169)\n" +
            "vlmhyer (25)\n" +
            "urjwj (78)\n" +
            "miijab (49)\n" +
            "faihy (65)\n" +
            "skkatyg (20)\n" +
            "zfnoo (18)\n" +
            "dcmxxd (35)\n" +
            "evnlr (1175) -> erfndpf, hicuenj, zybeuh\n" +
            "qzqyveb (80)\n" +
            "wpdbejb (90)\n" +
            "trbnpf (88)\n" +
            "yxxpgv (70)\n" +
            "wyomko (184) -> tgfgem, clnkvox\n" +
            "dxhcxko (45) -> ftzht, ypsme, rmtbjn, pjyld\n" +
            "lixsvp (11)\n" +
            "mofkvq (126) -> ejuiv, abmqz, xqobg\n" +
            "zqtkn (79) -> ugjzag, dtzyg\n" +
            "xhonf (95)\n" +
            "kiauwpn (22)\n" +
            "nmstp (44)\n" +
            "hsifo (210) -> wfdlusw, myonh, qunldzi\n" +
            "whnjtp (146) -> zswyy, bmugsve\n" +
            "txkgx (60)\n" +
            "icjur (76) -> lwaeqm, rhdudt\n" +
            "fpynzz (24) -> kepkgvf, kabixkr, jbexk\n" +
            "qunldzi (49)\n" +
            "ucxedq (84)\n" +
            "wndpfac (55)\n" +
            "hicuenj (122) -> ootidjt, hlrjgro, ywvmghy\n" +
            "kkdaw (65)\n" +
            "dmxhbe (141) -> myhrxc, jbbivz, behncf\n" +
            "borbd (21) -> ujktzrv, hbzju, xulwh, xatyg\n" +
            "adxhax (74)\n" +
            "zwsrt (2544) -> xmvbzka, egrfvic, fovkc\n" +
            "hhqlfj (81) -> xqgwwr, zmlmsuf\n" +
            "jiuuhl (78)\n" +
            "dcouu (6)\n" +
            "yetcvhx (71)\n" +
            "rfcfgg (28) -> sruyra, bqmqbi, uzuawb\n" +
            "pygfz (92) -> kledju, upevl\n" +
            "etscle (45)\n" +
            "pzjbbdd (93)\n" +
            "fjpgybt (21)\n" +
            "mjsck (90) -> mkkpihe, fmqjogk\n" +
            "cfuqhip (57) -> ixkicz, yqnihs, vifwkwa\n" +
            "jkamtqv (80)\n" +
            "ulvncs (172) -> bexvn, jzsmy\n" +
            "cytlm (46)\n" +
            "axikbt (9) -> tjffhqh, mogwb, cykvxs, ydqjoa\n" +
            "lageym (228)\n" +
            "jmlznjh (50)\n" +
            "wszghwt (160) -> brcpgz, wryfov\n" +
            "yxdld (38)\n" +
            "fukgfu (20)\n" +
            "mjlnaz (72) -> zcgfj, jiuuhl\n" +
            "bchfd (109) -> ccityq, nmvvgr\n" +
            "ogvod (1281) -> bihsr, erggh, dqgfb, xguhm\n" +
            "gcxrx (91)\n" +
            "ttnnyy (92) -> lhsccbq, dpdjpal\n" +
            "kxflpnl (16)\n" +
            "ehvqyl (192) -> zjgok, ecdieu\n" +
            "lsfggz (94) -> itttb, wpdbejb\n" +
            "aacegb (8)\n" +
            "wxdpcvv (8)\n" +
            "viufoq (25) -> bekxoxk, wmaywuo\n" +
            "pqnte (70)\n" +
            "rmtbjn (78) -> lytcy, aiunuvn, hfvhp, dczcz, kqaoir, ekihql, qkrydu\n" +
            "imjutr (187) -> wgeig, wqbhby\n" +
            "swpfak (21)\n" +
            "vmvxwar (38)\n" +
            "uxrrjqx (205)\n" +
            "mddejh (441)\n" +
            "fbhidp (17)\n" +
            "vunam (90)\n" +
            "rnbqhk (62) -> rdwkvr, oyamsv\n" +
            "bezvr (55)\n" +
            "kbses (93)\n" +
            "dqgfb (43) -> hpuyku, rycmr\n" +
            "uadnb (88)\n" +
            "dnrfjv (55)\n" +
            "wykkwa (67)\n" +
            "kyjkjy (62)\n" +
            "wrochvi (150) -> kifer, xaifomj, usodrg, jqkaucw\n" +
            "krmphks (12)\n" +
            "jbzaips (36)\n" +
            "qjaywg (94) -> khpat, jcpavmj, bchlcqs\n" +
            "kayqqz (77) -> kdqjj, sbdja, gmcsy\n" +
            "zjgok (23)\n" +
            "mrcoxnt (24)\n" +
            "wopfs (159) -> oasspz, zgssy\n" +
            "herqgqi (36)\n" +
            "zcdzv (11)\n" +
            "assuj (137) -> atfhgyu, pxhwecw\n" +
            "cvgbj (48)\n" +
            "lywkfsn (127)\n" +
            "cpfbmv (204)\n" +
            "scruak (30)\n" +
            "lsteeu (162) -> tatubv, rprjk, tgblta, uxrrjqx, pweea, sgieno\n" +
            "hhlxxzt (96) -> ixtrjm, tknmww, cnbekc\n" +
            "gmwtl (49)\n" +
            "sjiel (238)\n" +
            "pweea (51) -> eggmj, clpekkm\n" +
            "cnnrj (78)\n" +
            "eilzvpr (213) -> ksrsmjx, zpntow\n" +
            "cipwzoy (74)\n" +
            "apdfe (184) -> xrxseqy, leegl\n" +
            "bkkop (347)\n" +
            "cuhrgp (81) -> ohtply, vrfkofp\n" +
            "kepkgvf (73)\n" +
            "odkzxae (91)\n" +
            "qmqrpcl (92)\n" +
            "bgrxlxe (65)\n" +
            "xqobg (31)\n" +
            "awccm (86)\n" +
            "slhitu (27)\n" +
            "dihzy (79)\n" +
            "jfdscql (362) -> amrbhgv, rfdpm, ecxfenj, dxqqhhd\n" +
            "eqsxuaq (49)\n" +
            "hlcnxe (1998) -> fcpde, zyniqni, offjbb\n" +
            "pdmhva (18)\n" +
            "dtzyg (24)\n" +
            "xpker (36)\n" +
            "gqzva (6)\n" +
            "thqkxpl (38)\n" +
            "avelbqj (31)\n" +
            "mrigsjh (55)\n" +
            "ltbpi (17) -> vwcygm, herqgqi\n" +
            "odckjtb (72)\n" +
            "tdniuai (39)\n" +
            "tohrp (65)\n" +
            "wryfov (57)\n" +
            "vhrtptr (139) -> bpqhqbg, pacsxn\n" +
            "ohrraic (94)\n" +
            "eyale (97)\n" +
            "beraw (14)\n" +
            "mfywm (79) -> erkarx, vscjrx\n" +
            "knpwsi (261) -> cvgbj, uzjejte\n" +
            "wjyreb (41) -> rabxkov, rxqfv, gcomv\n" +
            "rdwkvr (38)\n" +
            "mmerpi (5)\n" +
            "cbgyk (43)\n" +
            "oxyof (44)\n" +
            "tjhmz (51)\n" +
            "zmqom (42) -> grazu, yxkldyi\n" +
            "rxanas (210) -> ctfjb, ifbxvs\n" +
            "lynvd (42593) -> tuieolg, pddteg, pixmx\n" +
            "scaec (96)\n" +
            "zbcra (38) -> rjeunph, edkigpl\n" +
            "ciogjt (375) -> tygnc, vhrtptr, ccckie\n" +
            "uvsny (44)\n" +
            "mpgixa (110) -> bmmmp, btxepbv\n" +
            "aqkdlo (24)\n" +
            "yjxyb (77) -> tceog, pqnte, yxxpgv, aokpx\n" +
            "tlayc (77)\n" +
            "kjlmdi (96)\n" +
            "rqhhyc (214) -> cizehi, sqypc\n" +
            "tgkusb (32)\n" +
            "xguhm (102) -> syyfs, hpeaki, fynniwm\n" +
            "koane (8) -> rawuoi, hkjwio, vpynuf, exxcrj, ljhtov, pwdpe, bdymucv\n" +
            "phmtqf (175) -> aodnlv, jancm\n" +
            "rjguqr (183) -> fgdqr, ccsrkny\n" +
            "mnhojtk (218) -> kvdrnf, nkjgwn\n" +
            "ejuiv (31)\n" +
            "rijipom (107) -> ijmfnt, ymduw, vdpmvm, njeff\n" +
            "bbfaxid (138)\n" +
            "yoqbgjb (25)\n" +
            "bymzb (68) -> zneumoh, zhopeqm\n" +
            "qntstgd (103) -> bbkfiz, zonni\n" +
            "ahqfoz (52)\n" +
            "gfqtz (98)\n" +
            "yvxuom (154) -> jbbmcxg, ppiiyuy\n" +
            "zxkvs (12) -> bclicjl, yfruc, axikbt, nglji\n" +
            "vwojb (97) -> qeubhb, kkdaw, ucfhxsv, rythrvz\n" +
            "akpnwc (90)\n" +
            "rawuoi (166) -> dzouqwl, vztyfp, dqgivj, cssov\n" +
            "eggmj (77)\n" +
            "isggu (5)\n" +
            "jszpe (39)\n" +
            "kmarvbs (90)\n" +
            "btxepbv (90)\n" +
            "hjjfdj (11)\n" +
            "sfrbkzf (45) -> tgmle, mddejh, tulxgem, ofidu, mjaol, dhqzt\n" +
            "ibvaekj (9)\n" +
            "leegl (94)\n" +
            "lfjtmkg (6095) -> lsteeu, zxkvs, sdhqlxw\n" +
            "itttb (90)\n" +
            "wlajxb (201) -> tgyavjg, eszxg\n" +
            "jlvwibm (46)\n" +
            "hcqnhm (58)\n" +
            "iqygrur (44)\n" +
            "bqifoq (55)\n" +
            "fovkc (49)\n" +
            "aozygag (125)\n" +
            "prcjhey (92)\n" +
            "fetkt (203) -> nnhsuja, kxflpnl, xumsm\n" +
            "qjzol (15)\n" +
            "rufvv (162) -> qzcbtes, xekimqs\n" +
            "dhlrq (88)\n" +
            "mwztduj (75)\n" +
            "ydumax (61)\n" +
            "boygd (13) -> wiayzvp, mdhhd, jkqvg, wouprxh\n" +
            "uyrght (80) -> hvcii, lxhkgs\n" +
            "nglji (311) -> cfaniht, anbcmt\n" +
            "pfutotv (44)\n" +
            "zvwkjew (60)\n" +
            "miftchq (21)\n" +
            "xaatl (56147) -> dgjls, qoiuwmf, koane, fnoteku, pavwo, hpowmso, yehxck\n" +
            "oejqkp (13)\n" +
            "oewlch (659) -> tgffx, eiwjrxx, ksybvgt\n" +
            "dwpqell (35)\n" +
            "mnksdxf (138)\n" +
            "obfet (87) -> iolmgs, piouhkc\n" +
            "kazqnjr (391) -> qngfv, aacegb\n" +
            "kmogwi (1139) -> hkjtym, tgujvov, dkttrfw\n" +
            "behncf (16)\n" +
            "ofosgz (80)\n" +
            "xejner (239) -> jmlznjh, foyfb, pxihdrd\n" +
            "ylyef (30)\n" +
            "lqumiws (88)\n" +
            "jancm (58)\n" +
            "rdkvtq (77)\n" +
            "alztgi (32)\n" +
            "myhrxc (16)\n" +
            "ycctk (1381) -> qtgibw, lkorngt, mufnw\n" +
            "wfovakv (48) -> lppvxfk, tznwmc, utgxfsh, zyympz, asbzj, ijcojo\n" +
            "lhsccbq (42)\n" +
            "tglnkgk (81) -> wrxiwgy, wrfxdc\n" +
            "ptkqcl (41)\n" +
            "cipgxee (72)\n" +
            "ecjdzpq (35)\n" +
            "ykpdiav (51)\n" +
            "wdjzjlk (1631) -> iplyhhc, pgchejz, kwmam\n" +
            "ymhxg (48) -> vohta, ohplzu, edpjix\n" +
            "vuetjdb (157) -> pbxjvnl, jdzbqlz, xhnmlcw, vipurf\n" +
            "skpcerk (88)\n" +
            "hfvhp (2018) -> wewzb, opmmmd, zmqom\n" +
            "afrywlt (80)\n" +
            "amrbhgv (126) -> xpker, gkkrlg, jbzaips\n" +
            "qsrpqe (236) -> brztp, kwwsxez\n" +
            "cdpfk (92)\n" +
            "oksoj (51)\n" +
            "eiwjrxx (45) -> hbsmlf, dlabh, rcjxcou\n" +
            "pzewv (23)\n" +
            "zonni (11)\n" +
            "nkssh (38)\n" +
            "nmvvgr (34)\n" +
            "iteizf (21)\n" +
            "dvfuz (30)\n" +
            "scmiv (54)\n" +
            "qqishhq (14)\n" +
            "egsil (38)\n" +
            "iipqh (299)\n" +
            "icqjyqd (16)\n" +
            "zktnjab (87)\n" +
            "nkskfx (94)\n" +
            "leulsg (44696) -> tifqyde, olkopyn, lfjtmkg\n" +
            "eskdbe (17)\n" +
            "dkhuccj (96) -> kbyot, zhbiaq, hhmavd, xejner, cqlwzk\n" +
            "mkyam (372)\n" +
            "wxixtqj (37)\n" +
            "ilxfa (34)\n" +
            "woczl (60) -> okseah, afeqhu, cnnrj, cmaxybh\n" +
            "rjnzany (44)\n" +
            "lppvxfk (1001) -> nrnmjo, phmtqf, bqznix\n" +
            "uzjxd (196) -> zfnoo, wlaslo, tijkvua\n" +
            "ekihql (1184) -> ezxsv, vonzkut, dkyswuu, uyrght, uzjxd, yjomyth\n" +
            "rljjjo (192) -> sobzsd, ykljt\n" +
            "mfjeyx (49) -> tdniuai, vdjmhb\n" +
            "qjdpk (28) -> wzxei, jopyit\n" +
            "liamld (25)\n" +
            "rjeunph (18)\n" +
            "vscjrx (79)\n" +
            "gwyfm (287) -> liamld, ucqdz\n" +
            "gnmydtk (67)\n" +
            "xspxxb (71)\n" +
            "mwirmq (188) -> mnpvutr, dmvjz\n" +
            "myonh (49)\n" +
            "mupbrv (218) -> phkwq, hrjgaqj, bwvemo\n" +
            "kztkiqt (13) -> egsil, mjugqpu\n" +
            "khpat (53)\n" +
            "wchlcja (190)\n" +
            "tjffhqh (84)\n" +
            "geqwvx (129) -> acxlck, zqnmsyb, ojnziip\n" +
            "ufyavk (1838) -> vunam, kmarvbs, kzdugfh\n" +
            "nvlxqp (58)\n" +
            "izhdt (57) -> gfqtz, sztqzfl\n" +
            "zfhxg (345) -> srneoo, ygmhxm, epumc\n" +
            "wkhggv (25)\n" +
            "jjvxxtt (194) -> ldfsxw, mhkcp\n" +
            "mhzgkxx (156) -> qzakfh, tnayomw\n" +
            "bchlcqs (53)\n" +
            "ymduw (28)\n" +
            "grazu (90)\n" +
            "fgdqr (34)\n" +
            "swrkuc (199) -> gylsj, cyzzsc, blmfs, aonfaf\n" +
            "zrpqdzn (62)\n" +
            "dkyswuu (120) -> zjzoo, bhxdhmr\n" +
            "mjugqpu (38)\n" +
            "gijtd (75)\n" +
            "huhoda (191) -> bpphw, eqsxuaq, gmwtl\n" +
            "vdkxk (90) -> hrvztx, fjhqmnv\n" +
            "huunb (88)\n" +
            "stiln (72)\n" +
            "exxcrj (316) -> dzjyzd, pkoww\n" +
            "bdymucv (304) -> uzsytm, sslltlv\n" +
            "dyscpqo (49)\n" +
            "tremw (94)\n" +
            "uotzz (61) -> xyxtm, cdpfk, qmqrpcl\n" +
            "vlpop (64) -> hshyx, tchbf\n" +
            "rdmggka (18)\n" +
            "owigu (9)\n" +
            "bpqhqbg (63)\n" +
            "aeyykn (66) -> lrkfnoy, ltdrusl\n" +
            "kwwsxez (27)\n" +
            "jgtpw (84) -> cxnjv, zelucu, ygurya, mrsrl\n" +
            "oljci (892) -> asifeu, aoehbj, oqjkafl\n" +
            "xqgwwr (23)\n" +
            "ctfjb (20)\n" +
            "cxnjv (66)\n" +
            "nrnmjo (105) -> pzjbbdd, nvvxl\n" +
            "wydbqai (65) -> ryulu, ydumax\n" +
            "ghdime (76)\n" +
            "cnvyxm (59)\n" +
            "xffvy (59)\n" +
            "qtgibw (52) -> ovvrx, ziypsz\n" +
            "ukkaxy (211)\n" +
            "yurfpj (65)\n" +
            "qvvcx (41)\n" +
            "ygurya (66)\n" +
            "zchulv (72) -> cmxulaj, tetdx, huhoda, blagy, wgypwo\n" +
            "rqzfef (86)\n" +
            "drgtn (84)\n" +
            "goxfpk (6)\n" +
            "bcjecw (80)\n" +
            "njabgq (57)\n" +
            "gcwcs (93) -> dokgk, epsjj\n" +
            "fhzhqie (65)\n" +
            "ccsrkny (34)\n" +
            "onlwq (59) -> ekxxsqa, jlfho, ekabfx\n" +
            "ldnrw (760) -> plumb, yvhilh, kztkiqt, ltbpi\n" +
            "nnxfo (63) -> xffvy, zqmlv, krcoaft, iimfrx\n" +
            "mrsrl (66)\n" +
            "vztyfp (57)\n" +
            "pacsxn (63)\n" +
            "maiimn (77)\n" +
            "usodrg (53)\n" +
            "rzphpv (48)\n" +
            "pavwo (1890) -> mofkvq, fmxtg, rijipom, mgqfa\n" +
            "gcomv (84)\n" +
            "pjxqt (46)\n" +
            "oywob (47) -> ynayo, ixxkvtz\n" +
            "fovilf (44)\n" +
            "ypsme (11966) -> zfkfhfn, fiufzkb, ubgrma, puurcu\n" +
            "etyyw (11)\n" +
            "ccityq (34)\n" +
            "hrjgaqj (29)\n" +
            "dhqzt (305) -> capxp, pttij\n" +
            "dpdjpal (42)\n" +
            "fbqpk (38)\n" +
            "qkrydu (1886) -> leyiz, mwirmq, hhwngc\n" +
            "mufrkl (60) -> wyomko, lafoho, rxanas, vlpop, ulvncs, padxpdx\n" +
            "cssov (57)\n" +
            "wgeig (15)\n" +
            "rythrvz (65)\n" +
            "juptypm (14)\n" +
            "dxympe (23)\n" +
            "ckwooig (84)\n" +
            "zgimdwb (107) -> znucug, mrigsjh\n" +
            "bbhyth (53) -> xcqwjrm, kgmwfq\n" +
            "vyriv (50) -> vwbjuvx, xergqq, wlpfcsr\n" +
            "qzcbtes (65)\n" +
            "kgmwfq (63)\n" +
            "losdis (1165) -> vhmijln, lteyo, viufoq\n" +
            "iplyhhc (122) -> cbgyk, dzohgiq\n" +
            "fpqudx (187) -> iuxgzr, icqjyqd, apmdcz, mhapqqy\n" +
            "jaxidl (86)\n" +
            "xhyqtqz (77) -> swrkuc, ncfuru, kazqnjr\n" +
            "rznnmp (70)\n" +
            "jvhxfl (39)\n" +
            "gxzkde (65)\n" +
            "uiwaf (97)\n" +
            "cfnce (59)\n" +
            "fkgxak (328) -> wpnqifq, xbucnh, qjwfsfk, rcsfkrb\n" +
            "nrcbc (98)\n" +
            "aodnlv (58)\n" +
            "yvhilh (89)\n" +
            "cyzzsc (52)\n" +
            "pjedtl (55)\n" +
            "bvrlaep (143) -> dnrfjv, wndpfac, bezvr\n" +
            "clpekkm (77)\n" +
            "wnyxznj (65)\n" +
            "wonxzkm (57)\n" +
            "vifwkwa (173) -> zvwkjew, txkgx, vvqpffs\n" +
            "qroirmg (45)\n" +
            "mdzkkjf (22)\n" +
            "pmfkdn (14)\n" +
            "qgfstpq (12)\n" +
            "mhydkla (7)\n" +
            "yekjlfd (106) -> ecjdzpq, dcmxxd\n" +
            "gxiwcqv (186) -> zfhwfsw, lovypfn\n" +
            "ifbxvs (20)\n" +
            "lwwyx (41) -> vuetjdb, ciejakr, imjutr, zgimdwb, sdnlegj, gzixhdc, tlvkwlx\n" +
            "tfdbdq (22)\n" +
            "dzggd (663) -> iipqh, nnxfo, veggtf\n" +
            "xwltxk (2001) -> yirnxk, baawtw, msfxkn\n" +
            "tznwmc (1199) -> dnfvldg, dbufjl, pnhibed\n" +
            "uiioczf (130)\n" +
            "rcjxcou (56)\n" +
            "tatubv (205)\n" +
            "vvqpffs (60)\n" +
            "bugwblt (14)\n" +
            "umtfn (80) -> hbylau, dzrkq, rugltaa\n" +
            "cqlwzk (217) -> besihsl, cwdmlj\n" +
            "pxteg (56) -> odkzxae, gcxrx, cotpovw\n" +
            "nbivp (106) -> ndnku, gjcxbx, iqygrur, oxyof\n" +
            "twvib (18)\n" +
            "fyzeso (57)\n" +
            "nlndxah (11)\n" +
            "wolet (91)\n" +
            "pixmx (4482) -> hrgbkby, bvfcsls, tzvawqb, jfdscql, gqggcxb\n" +
            "ctytfj (29)\n" +
            "lwaeqm (83)\n" +
            "cnbekc (92)\n" +
            "ekzvjj (35)\n" +
            "zgssy (67)\n" +
            "hbylau (94)\n" +
            "yonjpz (62)\n" +
            "btcjg (57)\n" +
            "tdbne (72)\n" +
            "edkigpl (18)\n" +
            "amnoi (141) -> noxvvva, dfeyr\n" +
            "gwtcgyo (24)\n" +
            "zrnlo (42)\n" +
            "ndnku (44)\n" +
            "etwwy (16)\n" +
            "hsoxt (62)\n" +
            "kdqjj (16)\n" +
            "cgouh (26)\n" +
            "mnvgaqh (128) -> jntohm, vobeup, ptkqcl\n" +
            "ocgkcxp (13)\n" +
            "ayaouxu (200) -> ksyewek, gpfrztg\n" +
            "baawtw (50) -> nnguamj, yetcvhx\n" +
            "ykljt (13)\n" +
            "znucug (55)\n" +
            "ypqxs (31)\n" +
            "pmgrf (21)\n" +
            "anmeg (58)\n" +
            "fmxtg (84) -> ursjc, eqhxqxm, qroirmg\n" +
            "dgjls (1926) -> lgxjr, hrphtyk, mhzgkxx\n" +
            "prxseo (16)\n" +
            "vhxlart (70)\n" +
            "zyniqni (147) -> khqhd, zrnlo\n" +
            "dtexqt (88)\n" +
            "mqybmn (86)\n" +
            "pljyyn (73)\n" +
            "jzibybz (248) -> zrpqdzn, hsoxt\n" +
            "dokgk (17)\n" +
            "bclicjl (217) -> dxufd, jhcsmc\n" +
            "tlvkwlx (133) -> fjpgybt, miftchq, oyfma, ytivjxk\n" +
            "qsqis (1208) -> aovlz, mxusu\n" +
            "mhkba (21)\n" +
            "kvdrnf (72)\n" +
            "fcpde (175) -> beraw, qqishhq, citugfl, pmfkdn\n" +
            "jcpavmj (53)\n" +
            "bbkfiz (11)\n" +
            "wqbhby (15)\n" +
            "mfvkd (21)\n" +
            "hhifd (6)\n" +
            "ibonrqn (50)\n" +
            "jzuvrtp (57)\n" +
            "zelucu (66)\n" +
            "zneumoh (80)\n" +
            "ljhtov (394)\n" +
            "okmqiy (46)\n" +
            "cmaxybh (78)\n" +
            "phkwq (29)\n" +
            "mvfhc (420) -> wchlcja, ikfihh, ybnvm, cztikzk, qhmyi, uebnns\n" +
            "jzsmy (39)\n" +
            "edpjix (58)\n" +
            "myaiu (129) -> pqmrmke, iizbmoz, rhkbrsr, apwsmv\n" +
            "mnkqevh (98)\n" +
            "noxvvva (94)\n" +
            "ncfuru (87) -> bcjecw, kybsigz, mtcxdod, ofosgz\n" +
            "pttij (68)\n" +
            "eutcl (77)\n" +
            "mzwbtsa (119) -> eceocsy, ecoqyk\n" +
            "wrxiwgy (25)\n" +
            "fydjnl (32)\n" +
            "bsixe (80)\n" +
            "oxcuf (80) -> crobb, xpfxwd\n" +
            "yqnihs (56) -> wqoucl, rsqyvy, zetvslt\n" +
            "mqhkd (100) -> pjhry, ljhxxd\n" +
            "bwvemo (29)\n" +
            "hbsmlf (56)\n" +
            "sduuog (9)\n" +
            "nnguamj (71)\n" +
            "xrhsy (266) -> qbrrjg, juptypm, bugwblt\n" +
            "rxqfv (84)\n" +
            "bqqwmry (73)\n" +
            "gyutarg (51) -> adbolgz, vdvadz\n" +
            "vyozfv (99)\n" +
            "njrfnvt (96)\n" +
            "ruxnrix (35)\n" +
            "sgieno (107) -> miijab, zryrfnw\n" +
            "vpynuf (214) -> akpnwc, rulhhsl\n" +
            "mkbgt (98)\n" +
            "iwyjkz (86)\n" +
            "itxycu (45) -> eutcl, kdevmnr\n" +
            "ytspbx (184) -> nkskfx, ohrraic\n" +
            "ayejq (86)\n" +
            "fhpaqmd (23)\n" +
            "jjqguew (24)\n" +
            "mnfqc (789) -> zqtkn, hhqlfj, lywkfsn\n" +
            "aplbnbx (28)\n" +
            "hshyx (93)\n" +
            "ozfzz (11)\n" +
            "rhbouej (181) -> udkyxw, rzphpv\n" +
            "wchxl (67)\n" +
            "inghbu (1167) -> vcvypf, ljqmiu, tglnkgk\n" +
            "fticuc (1360) -> vleydj, lnczb, igpabio, wydbqai\n" +
            "ivwcuc (88)\n" +
            "peuppj (29) -> oqrmida, txxnutu, fzqsahw\n" +
            "ppiiyuy (34)\n" +
            "mgkkyx (77)\n" +
            "akwfu (50) -> tremw, uwhjd\n" +
            "tceog (70)\n" +
            "acxlck (73)\n" +
            "woves (32)\n" +
            "veksns (308) -> slhitu, lghzki\n" +
            "ljhxxd (38)\n" +
            "dqgivj (57)\n" +
            "sdbksb (171) -> hbkjjtt, zxson\n" +
            "erfnrn (6)\n" +
            "nclwgga (201)\n" +
            "mdhhd (28)\n" +
            "rhzimzq (74) -> drgtn, raqjoxn\n" +
            "rqymw (97)\n" +
            "nkjgwn (72)\n" +
            "vwcygm (36)\n" +
            "acfyjc (85)\n" +
            "iajslqp (32) -> avelbqj, ebgdslc, vzqnfs\n" +
            "dlhiqh (7301) -> rdrad, vmmjgy, uvmqarq\n" +
            "koxiwk (929) -> fcscdg, geqwvx, jgtpw, zorvynv, zotwsb\n" +
            "yjomyth (97) -> oksoj, lmwrf, tjhmz\n" +
            "hhwngc (138) -> ewpbnsk, swurfm\n" +
            "ikdsvc (1609) -> icjur, ebmjz, rxivjo, rhzimzq\n" +
            "mewof (12)\n" +
            "bmugsve (36)\n" +
            "zcgfj (78)\n" +
            "dyimc (54)\n" +
            "iuxgzr (16)\n" +
            "fxasat (57)\n" +
            "ixkicz (353)\n" +
            "fvfek (96)\n" +
            "rycmr (82)\n" +
            "xfydt (87)\n" +
            "ybnvm (50) -> dwpqell, fmtyy, bkcghv, ekzvjj\n" +
            "abbnh (33)\n" +
            "pbxjvnl (15)\n" +
            "lrkfnoy (78)\n" +
            "lpbayb (8)\n" +
            "oeqvt (19) -> grcox, otplae\n" +
            "bdafpm (58)\n" +
            "upevl (95)\n" +
            "jijwa (3632) -> xwltxk, ikdsvc, tcghqr\n" +
            "tgyavjg (18)\n" +
            "bwrpskq (65)\n" +
            "lhsncv (67)\n" +
            "kqaoir (80) -> ytspbx, dyrvvfn, bkldmro, qonfiro, hhlxxzt, jzibybz, slrfd\n" +
            "dlabh (56)\n" +
            "drfwgmu (249) -> zktnjab, cmfkxo\n" +
            "qbrrjg (14)\n" +
            "tijkvua (18)\n" +
            "stkodp (84)\n" +
            "zunhob (79)\n" +
            "dnfvldg (85) -> yjakrqa, lahain\n" +
            "pjyld (10676) -> zfhxg, oenxsfm, ciogjt, ebmcu, mnfqc, zgqzrc, pzksun\n" +
            "dxufd (64)\n" +
            "zryrfnw (49)\n" +
            "ycacj (25)\n" +
            "smmgkir (31)\n" +
            "bymkeq (71)\n" +
            "bzsiwp (71)\n" +
            "wqoucl (99)\n" +
            "njdmj (73)\n" +
            "tzvawqb (1010) -> qirjqsm, muksdck, oxcuf\n" +
            "ljqmiu (31) -> ibonrqn, imezigo\n" +
            "pppxrv (62)\n" +
            "xbyjur (14)\n" +
            "hkjtym (247) -> iwsjla, thqkxpl\n" +
            "ucqdz (25)\n" +
            "ekxxsqa (83)\n" +
            "jbexk (73)\n" +
            "mkkpihe (24)\n" +
            "evcdf (57)\n" +
            "sobzsd (13)\n" +
            "rfohgya (25)\n" +
            "ahmitv (11)\n" +
            "wtyfb (238)\n" +
            "inldh (4965) -> ogvod, agliie, wenii\n" +
            "mieecfc (138) -> lwljcg, acfyjc\n" +
            "yrlks (44)\n" +
            "gcbcyn (289) -> vflyupn, mbwenqu\n" +
            "xevhcxq (86)\n" +
            "xayglgm (21)\n" +
            "hdlovco (5)\n" +
            "awagc (18)\n" +
            "zqnul (38)\n" +
            "rhkbrsr (31)\n" +
            "ejzeqxz (51)\n" +
            "onogiv (30)\n" +
            "ltdrusl (78)\n" +
            "yzptgez (29)\n" +
            "bkldmro (212) -> bsixe, afrywlt\n" +
            "zksmijj (189) -> zsvuw, hjjfdj\n" +
            "pqmrmke (31)\n" +
            "gzixhdc (124) -> ypqxs, setrric, smmgkir\n" +
            "ytivjxk (21)\n" +
            "wiayzvp (28)\n" +
            "hbkjjtt (61)\n" +
            "rhdudt (83)\n" +
            "eqhxqxm (45)\n" +
            "gpfrztg (54)\n" +
            "slrfd (340) -> etwwy, qldijf\n" +
            "iolmgs (95)\n" +
            "ckhip (88) -> vhxlart, rznnmp\n" +
            "pcdjo (63)\n" +
            "ojnziip (73)\n" +
            "nvdouwn (161) -> llibmc, jkfob, dyscpqo\n" +
            "gbnxgny (12)\n" +
            "vzqnfs (31)\n" +
            "lixqwd (35)\n" +
            "crobb (8)\n" +
            "vdbihjp (69)\n" +
            "llibmc (49)\n" +
            "lkorngt (132) -> tjpatnk, nmstp\n" +
            "ecxfenj (78) -> urjwj, jesiypo\n" +
            "ekabfx (83)\n" +
            "opqoq (648) -> mjlnaz, bymzb, lmqaxz, lageym\n" +
            "yfruc (303) -> pmgrf, hsfjd\n" +
            "fkbrmim (71889) -> peuppj, uobgj, llventw, duepwu\n" +
            "nzwxd (103) -> wykkwa, oydxsh, bozlg\n" +
            "kcuygjx (71)\n" +
            "hvcii (85)\n" +
            "fjhqmnv (57)\n" +
            "txxnutu (97) -> bcyarwn, uteosk, kjjyu\n" +
            "hrgbkby (53) -> saowgr, lprmau, ntabiof\n" +
            "xhnmlcw (15)\n" +
            "clnkvox (33)\n" +
            "bhwca (76)\n" +
            "uojcup (985) -> ttnnyy, yekjlfd, pdxylvu, fjzpjk, mqhkd, ibiwh\n" +
            "mxusu (45)\n" +
            "ixxkvtz (71)\n" +
            "gqggcxb (29) -> tzrppo, bugfhhx, drfwgmu\n" +
            "bsrkr (21)\n" +
            "erkarx (79)\n" +
            "kabcmf (51)\n" +
            "tknmww (92)\n" +
            "qgvsuqv (206) -> jhgsgy, enbnfw, uflldd, jvhxfl\n" +
            "cfaniht (17)\n" +
            "jrgwnfh (57)\n" +
            "rdmrzdv (99)\n" +
            "krcoaft (59)\n" +
            "ifelr (77)\n" +
            "hpaggeh (88)\n" +
            "wlaslo (18)\n" +
            "wouprxh (28)\n" +
            "hhmavd (359) -> pxzdv, qjzol\n" +
            "bqmqbi (47)\n" +
            "aokpx (70)\n" +
            "lteyo (157) -> mfvkd, swpfak\n" +
            "hrphtyk (19) -> xjcprt, bbzmsv, berje\n" +
            "pkoww (39)\n" +
            "jsjaxjk (88) -> aidknm, uiwaf\n" +
            "uebnns (127) -> iteizf, lzxrfk, tlfsn\n" +
            "wcevmtt (77)\n" +
            "yxkldyi (90)\n" +
            "qpefm (823) -> kmogwi, ufyavk, evnlr, rmlddp, fticuc\n" +
            "cmfkxo (87)\n" +
            "qldijf (16)\n" +
            "nstdz (65)\n" +
            "aoehbj (182) -> dyimc, scmiv\n" +
            "eceocsy (35)\n" +
            "hwrxn (53) -> dihzy, ibysnvc, zunhob\n" +
            "nglea (50) -> pfutotv, yrlks\n" +
            "fmqjogk (24)\n" +
            "tgblta (141) -> elmog, woves\n" +
            "jkfob (49)\n" +
            "vcvypf (113) -> mttvnpg, sduuog\n" +
            "wlpfcsr (99)\n" +
            "lybovx (18)\n" +
            "mbwenqu (34)\n" +
            "obkhwze (38)\n" +
            "vleydj (173) -> mhydkla, msthql\n" +
            "uduan (75)\n" +
            "ykruy (39)\n" +
            "aiunuvn (1629) -> gjrqs, ukkaxy, lijeejc, zlgpmfs, zksmijj\n" +
            "lqavsk (73)\n" +
            "afeqhu (78)\n" +
            "veggtf (104) -> wnyxznj, mnwefbn, fhzhqie\n" +
            "jbbivz (16)\n" +
            "uzjejte (48)\n" +
            "jhysc (274) -> cldbz, cluxnul\n" +
            "vhmijln (97) -> tmyhhql, ykpdiav\n" +
            "nqvflzq (61)\n" +
            "cotpovw (91)\n" +
            "yookz (5)\n" +
            "skjtvyz (18)\n" +
            "szutvca (32)\n" +
            "navhthp (136) -> rrywqx, vjxmbzm\n" +
            "okseah (78)\n" +
            "ebmcu (30) -> glsrg, ckhip, rqhhyc, jjvxxtt, rdnpoms\n" +
            "wuybunc (54)\n" +
            "oktfn (37)\n" +
            "tvnco (63)\n" +
            "tfpuqgs (24)\n" +
            "ijmfnt (28)\n" +
            "zswyy (36)\n" +
            "sqiac (24)\n" +
            "xbucnh (11)\n" +
            "zmpwz (12)\n" +
            "cotvk (91)\n" +
            "ohtply (49)\n" +
            "ysigfem (177)\n" +
            "jlfgvr (72)\n" +
            "kplegas (86)\n" +
            "mbezs (71)\n" +
            "rprjk (205)\n" +
            "jlfho (83)\n" +
            "melsryt (58)\n" +
            "oenxsfm (275) -> cuhrgp, qlgme, bbhyth, dnzdqz, ezdhr\n" +
            "sdnlegj (207) -> hdlovco, mmerpi\n" +
            "dzouqwl (57)\n" +
            "rugltaa (94)\n" +
            "imezigo (50)\n" +
            "iizbmoz (31)\n" +
            "vipurf (15)\n" +
            "awufxne (2141) -> qllluo, wpoga\n" +
            "gkkrlg (36)\n" +
            "dfeyr (94)\n" +
            "zmlmsuf (23)\n" +
            "lzxrfk (21)\n" +
            "jhcsmc (64)\n" +
            "ksyewek (54)\n" +
            "jzcmf (24)\n" +
            "xumsm (16)\n" +
            "eiyxf (32)\n" +
            "intfltq (33)\n" +
            "yhyxv (160) -> ahmitv, ozfzz, zcdzv, rhlllw\n" +
            "jopyit (51)\n" +
            "rmlddp (64) -> rufvv, gxiwcqv, cjcapa, exwxepj, qvbfob, zimrsr, nrcbij\n" +
            "dnazkh (80)\n" +
            "raqjoxn (84)\n" +
            "cgfykiv (38)\n" +
            "tygnc (13) -> ucxedq, jgwvp, kgevjdx\n" +
            "ojhlp (137) -> zqnul, vmvxwar, cgfykiv\n" +
            "hpuyku (82)";
}