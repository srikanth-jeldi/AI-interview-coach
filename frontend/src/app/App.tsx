import { Link, Route, Routes } from 'react-router-dom';
import { motion } from 'framer-motion';
import { LandingPage } from '../features/technology/LandingPage';
import { TechnologyExplorerPage } from '../features/technology/TechnologyExplorerPage';
import { QuestionBankPage } from '../features/questions/QuestionBankPage';
import { QuestionDetailPage } from '../features/questions/QuestionDetailPage';
import { MockInterviewFlowPage } from '../features/mock/MockInterviewFlowPage';
import { DashboardPage } from '../features/dashboard/DashboardPage';
import { JobsPage } from '../features/jobs/JobsPage';
import { RoadmapPage } from '../features/roadmap/RoadmapPage';
import { ProfilePage } from '../features/profile/ProfilePage';
import { AdminPage } from '../features/admin/AdminPage';
import { AuthPage } from '../features/auth/AuthPage';

const nav = [
  ['/', 'Home'], ['/dashboard', 'Dashboard'], ['/tech', 'Technologies'], ['/questions', 'Question Bank'],
  ['/mock', 'Mock Interview'], ['/jobs', 'Jobs'], ['/roadmap', 'Roadmap'], ['/profile', 'Profile'], ['/admin', 'Admin']
];

export function App() {
  return (
    <div className="min-h-screen">
      <header className="sticky top-0 border-b border-violet-500/20 bg-slate-950/90 backdrop-blur">
        <nav className="mx-auto flex max-w-7xl gap-3 overflow-x-auto p-3 text-sm">
          {nav.map(([to, label]) => <Link key={to} to={to} className="rounded-md px-3 py-1 hover:bg-cyan-500/10">{label}</Link>)}
        </nav>
      </header>
      <motion.main initial={{ opacity: 0 }} animate={{ opacity: 1 }} className="mx-auto max-w-7xl p-4">
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/auth" element={<AuthPage />} />
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/tech" element={<TechnologyExplorerPage />} />
          <Route path="/questions" element={<QuestionBankPage />} />
          <Route path="/questions/:id" element={<QuestionDetailPage />} />
          <Route path="/mock" element={<MockInterviewFlowPage />} />
          <Route path="/jobs" element={<JobsPage />} />
          <Route path="/roadmap" element={<RoadmapPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/admin" element={<AdminPage />} />
        </Routes>
      </motion.main>
    </div>
  );
}
