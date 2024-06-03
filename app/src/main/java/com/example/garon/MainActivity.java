//package com.example.garon;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.garon.domain.Form;
//
//public class MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        EntityManager em = JPAUtil.getEntityManager();
//
//        try {
//            em.getTransaction().begin();
//
//            // 엔티티 생성 및 저장
//            Form form = Form.builder()
//                    .startDate(getStartDate)
//                    .startTime("10:00")
//                    .studentId(12345L)
//                    .name("John Doe")
//                    .sex("M")
//                    .phone("123-456-7890")
//                    .build();
//
//            em.persist(form);
//            em.getTransaction().commit();
//
//            // 엔티티 조회
//            Form foundForm = em.find(Form.class, form.getId());
//            System.out.println("Found Form: " + foundForm.getName());
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//            JPAUtil.close();
//        }
//    }
//}