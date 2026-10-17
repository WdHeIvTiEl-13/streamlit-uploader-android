# Streamlit GitHub Folder Uploader — Android APK builder

এই project টি তোমার existing deployed Streamlit app-কে Android app icon থেকে খুলতে দেয় এবং GitHub Actions-এ APK build করে।

## গুরুত্বপূর্ণ
- এই APK তোমার deployed Streamlit URL খুলবে; Python/Streamlit server APK-এর ভিতরে চলে না।
- OAuth login নির্ভরযোগ্য রাখতে embedded WebView-এর বদলে Chrome Custom Tab ব্যবহার করা হয়েছে।
- তোমার বর্তমান Streamlit app ZIP upload করে। ZIP-এর ভিতরের folder structure GitHub-এ রাখা হয়; এই version-এ Android থেকে সরাসরি folder pick নয়, ZIP file pick করতে হবে।
- Streamlit URL বদলালে `app/src/main/java/com/example/streamlituploader/MainActivity.kt`-এর `APP_URL` বদলাবে।
- GitHub OAuth Client Secret বা access token Android project-এ রাখবে না। এগুলো Streamlit Cloud Secrets-এ থাকবে।

## ফোন থেকে APK build
1. ZIP extract না করেও চাইলে repository-তে project files যোগ করতে পারো; সহজ উপায় হলো এই ZIP extract করে নতুন GitHub repository-তে সব files upload করা।
2. Repository-র default branch `main` রাখো।
3. GitHub → Actions → **Build Android APK** → **Run workflow**।
4. Workflow সফল হলে run page-এর Artifacts থেকে `streamlit-uploader-apk` download করো।
5. ZIP extract করে `app-debug.apk` install করো। Android-এ browser/downloaded apps থেকে install করার permission চাইতে পারে; শুধুমাত্র নিজের build করা APK install করো।

## Build settings
- Java 17
- Gradle 8.9
- Android Gradle Plugin 8.7.3
- Debug APK; public distribution-এর জন্য আলাদা release signing প্রয়োজন।
