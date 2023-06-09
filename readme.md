# 居残りメーラー定時起動方法説明

<div>
居残りお疲れ様です。毎日上司へのメール送るの大変ですよね。<br>
居残りメーラーは、毎日自動で起動するように設定することで、<br>
忘れることなく、より楽にメールを送信できます。では早速。
</div>

<br>
<br>
<br>



<br>
<h2 id="XML">1. XMLファイルをタスクスケジューラで読み込む</h2>
<ol>
<li>windowsのタスクスケジューラを起動。</li>
<li>右の方の、"タスクをインポート"を選び、プロジェクトファイル内の「メーラー起動.xml」を読み込む。</li>
</ol>

<br>
<br>




<div id="bat">
<h2>2. batファイルの設定</h2>
<ol>
<li>プロジェクトファイル内のbootMailer.batを右クリック。編集を押下し、メモ帳などで編集をする。</li>
<li>以下のように記述。</li>
</ol>
<br>
<p>@echo off<br>
START "居残りメーラーのjarファイルの場所のパス" /B<br>
START "ブラウザへのパス"/B indexを開くためのURL<br>
EXIT</p>
<br>

※私の環境では以下のようになりました。参考まで。<br>
@echo off<br>
START "C:\Users\axiz\IdeaProjects\mailer\target\mailer-0.0.1-SNAPSHOT.jar" /B<br>
START "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Google Chrome.lnk"/B http://localhost:8080/index <br>
EXIT

</div>

<br>
<br>

<h2>3. タスクスケジューラの設定</h2>

<div id="timeScheduler">
<ul>
<li>操作タブの「新規」を選択し、「プログラム/スクリプト」の欄に、先ほどのbatファイルのパスを書けばOKです。<br></li>
<li><p>
その他のトリガーなどの設定は下記のサイト等を参考にしてください。<br>
https://qiita.com/bigyoujdb/items/9c049e7f92c5219e3076<br></p></li>
<li>タスクが作れたら、「実行」を選択して、実際に起動できるか試してみてください。</li>
</div>


<br>
<br>

# 以上！それでは楽しい居残りライフを！

